package fses.fms.model;

import java.util.Date;

public class Appointment {
    private String fmsId;
    private String vwsId;
    private Date dateTime;
    private Vehicle vehicle;
    private boolean fmsAccepted;
    private boolean vwsAccepted;
    private String message;

    public String getFmsId() {
        return fmsId;
    }

    public void setFmsId(String fmsId) {
        this.fmsId = fmsId;
    }

    public String getVwsId() {
        return vwsId;
    }

    public void setVwsId(String vwsId) {
        this.vwsId = vwsId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isFmsAccepted() {
        return fmsAccepted;
    }

    public void setFmsAccepted(boolean fmsAccepted) {
        this.fmsAccepted = fmsAccepted;
    }

    public boolean isVwsAccepted() {
        return vwsAccepted;
    }

    public void setVwsAccepted(boolean vwsAccepted) {
        this.vwsAccepted = vwsAccepted;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
