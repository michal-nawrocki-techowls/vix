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

    int odometerReading;

    @NotNull
    DistanceUnit distanceUnit;

    @NotNull
    Date dateOfInspection;

    @NotNull
    String operator;

    @NotNull
    Declaration declaration;

    @NotNull
    Byte[] file;

    @NotNull
    String fileName;

    List<Comments> commentsOnFaultsFoundList;
    List<ActionTaken> actionTakenOnFaultsFoundList;

    List<Inspection> inspectionList;
    List<Tyre> tyreList;
    List<Brake> brakeList;

    String makeAndModelType;
    String isoWkNo;


}
