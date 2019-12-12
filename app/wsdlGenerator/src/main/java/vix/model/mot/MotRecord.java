package vix.model.mot;

import vix.model.FileRecord;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class MotRecord extends FileRecord {

    private String countryOfRegistration;
    private String vehicleCategory;
    private Date expiryDate;
    private Date earliestInspectionDate;
    private String locationOfTheTest;
    private String testNumber;
    private boolean testPassed;
    @NotNull
    private List<Defect> defectList;

}
