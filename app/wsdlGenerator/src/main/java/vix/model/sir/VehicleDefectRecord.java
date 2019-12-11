package vix.model.sir;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class VehicleDefectRecord {

    //https://assets.publishing.service.gov.uk/government/uploads/system/uploads/attachment_data/file/785463/
    // guide-to-maintaining-roadworthiness-commercial-goods-and-passenger-carrying-vehicles.pdf
    //page 94-97

    @NotNull
    String vrm;
    @NotNull
    Integer odometerReading;

    String makeAndModelType;
    @NotNull
    Date dateOfInspection;

    String isoWkNo;
    @NotNull
    String operator;

    @NotNull
    Declaration declaration;

    @NotNull
    Byte[] file;

    @NotNull
    String fileName;

    List<Comments> commentsOnFaultsFoundList;
    List<Comments> actionTakenOnFaultsFoundList;

    List<DefectRecord> defectRecordList;
    List<Tyre> tyres;
    BrakePerformance brakePerformance;

}
