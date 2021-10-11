package example.vix.service;

import example.vix.model.Company;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class FileService {

    @Value("${app.directory-root}")
    private String root;

    public List<String> getFiles(Company company, Date startDate, Date endDate) {
        File files = new File(root + company.getDirName());
        return Arrays.asList(files.list());
    }

    public File getFile(Company company, String id) {
        return new File(root + company.getDirName() + "/" + id);

    }
}
