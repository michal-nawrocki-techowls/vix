package vix.model.sir;

import vix.model.FileRecord;

import javax.validation.constraints.NotNull;
import java.util.List;

public class VehicleDefectRecord extends FileRecord {

    //https://assets.publishing.service.gov.uk/government/uploads/system/uploads/attachment_data/file/785463/
    // guide-to-maintaining-roadworthiness-commercial-goods-and-passenger-carrying-vehicles.pdf
    //page 94-97

    @NotNull
    Declaration declaration;
    @NotNull
    List<Comments> commentsOnFaultsFoundList;
    @NotNull
    List<ActionTaken> actionTakenOnFaultsFoundList;
    @NotNull
    List<Inspection> inspectionList;
    @NotNull
    List<Tyre> tyreList;
    @NotNull
    List<Brake> brakeList;

    String makeAndModelType;
    String isoWkNo;

}
