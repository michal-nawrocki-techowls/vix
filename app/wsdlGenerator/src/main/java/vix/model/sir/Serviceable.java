package vix.model.sir;

import org.springframework.beans.factory.annotation.Required;

public enum Serviceable {
    SATISFACTORY,
    SAFETY_ITEM_DEFECT,
    REPAIR_REQUIRED,
    NOT_APPLICABLE,
    MONITOR

}
