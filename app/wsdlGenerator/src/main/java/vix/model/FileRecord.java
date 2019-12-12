package vix.model;

import vix.model.unit.DistanceUnit;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class FileRecord {
    @NotNull
    String vrm;

    int odometerReading;

    @NotNull
    DistanceUnit odometerReadingUnit;

    @NotNull
    Date dateOfInspection;

    @NotNull
    String operator;

    @NotNull
    Byte[] file;

    @NotNull
    String fileName;
}
