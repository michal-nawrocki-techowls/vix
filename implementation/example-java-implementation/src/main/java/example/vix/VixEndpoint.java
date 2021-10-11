package example.vix;

import example.vix.config.WsConfig;
import example.vix.model.Company;
import example.vix.service.CompanyService;
import example.vix.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import uk.co.fleetplanner.vix.*;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Endpoint
public class VixEndpoint {

    @Value("${app.software-provider}")
    private String softwareProvider;

    @Value("${app.company-provider-name}")
    private String companyProviderName;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private FileService fileService;

    @PayloadRoot(namespace = WsConfig.VIX_NAMESPACE, localPart = "AboutRequest")
    @ResponsePayload
    public AboutResponse getAbout(@RequestPayload AboutRequest request) throws Exception {
        Company company = companyService.findOneByToken(request.getToken());
        if (company == null) {
            throw new InvalidTokenException();
        }
        AboutResponse resp = new AboutResponse();
        resp.setCompanyName(companyProviderName);
        resp.setSoftwareProvider(softwareProvider);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, company.getTokenTtlInDays());
        XMLGregorianCalendar xgc = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar(cal);
        resp.setTokenTtl(xgc);
        return resp;
    }

    @PayloadRoot(namespace = WsConfig.VIX_NAMESPACE, localPart = "DocumentListRequest")
    @ResponsePayload
    public DocumentListResponse documentList(@RequestPayload DocumentListRequest request) throws Exception {
        Company company = companyService.findOneByToken(request.getToken());
        if (company == null) {
            throw new InvalidTokenException();
        }
        ObjectFactory factory = new ObjectFactory();
        DocumentListResponse resp = factory.createDocumentListResponse();
        DocumentList dl = factory.createDocumentList();
        resp.setDocuments(dl);

        List<String> list = fileService.getFiles(company,
                request.getDateFrom().toGregorianCalendar().getTime(),
                request.getDateTo().toGregorianCalendar().getTime());

        for (String s : list) {
            try {
                String[] name = s.split(" ");
                if (name.length != 3) {
                    continue;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd_hhMMss");
                DocumentDescription ddo = new DocumentDescription();
                ddo.setVrm(name[0]);
                ddo.setId(s);
                GregorianCalendar gco = new GregorianCalendar();
                gco.setTime(sdf.parse(name[2].split("\\.")[0]));
                ddo.setDateTime(DatatypeFactory.newInstance()
                        .newXMLGregorianCalendar(gco));
                ddo.setType(DocumentType.valueOf(name[1]));
                dl.getDocument().add(ddo);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return resp;
    }

    @PayloadRoot(namespace = WsConfig.VIX_NAMESPACE, localPart = "DocumentRequest")
    @ResponsePayload
    public DocumentResponse getDocument(@RequestPayload DocumentRequest request) throws Exception {
        Company company = companyService.findOneByToken(request.getToken());
        if (company == null) {
            throw new InvalidTokenException();
        }
        File file = fileService.getFile(company, request.getId());

        if (file == null) {
            throw new ObjectNotExistException();
        }
        String[] name = file.getName().split(" ");
        if (name.length != 3) {
            throw new ObjectNotExistException();
        }
        ObjectFactory factory = new ObjectFactory();
        DocumentResponse resp = factory.createDocumentResponse();

        if (DocumentType.SAFETY_INSPECTION.equals(DocumentType.valueOf(name[1]))) {
            SafetyInspection si = factory.createSafetyInspection();
            si.setContainsTwoSignatures(true);
            si.setAllSectionsAreAnswered(true);
            si.setRecordsIncludeAllTheRequirements(true);
            si.setIncludeConfirmationOfTheRoadworthiness(true);
            resp.setDocument(createDoc(si, name[0], name[2].split("\\.")[0], DocumentType.SAFETY_INSPECTION, file));
        } else if (DocumentType.MOT.equals(DocumentType.valueOf(name[1]))) {
            Mot si = factory.createMot();
            si.setInitialTestStatus(InitialMotTestStatus.PASS);
            resp.setDocument(createDoc(si, name[0], name[2].split("\\.")[0], DocumentType.MOT, file));
        } else {
            Other si = factory.createOther();
            resp.setDocument(createDoc(si, name[0], name[2].split("\\.")[0], DocumentType.OTHER, file));
        }

        return resp;
    }

    private Document createDoc(Document d, String vrm, String date, DocumentType type, File file) throws Exception {

        d.setVrm(vrm);
        d.setDocumentType(type);
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd_hhMMss");
        gc.setTime(sdf.parse(date));
        XMLGregorianCalendar xgc = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar(gc);

        d.setDateTime(xgc);
        d.setFileName(file.getName());
        d.setFile(Files.readAllBytes(file.toPath()));
        return d;
    }

}
