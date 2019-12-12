package vix.model.sir;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Declaration {

    public static String DEF_DESC = "I consider that the above defects have been rectified satisfactorily and this vehicle\n" +
            "is now in a safe and roadworthy condition.";

    private String description;

    @NotNull
    private String madeByName;
    private String madeByPosition;
    private Date date;
    private boolean safeAndRoadworthyCondition;

}
