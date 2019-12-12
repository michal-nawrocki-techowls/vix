package vix.model.sir;

import vix.model.unit.DistanceUnit;
import vix.model.unit.TemperatureUnit;

public class Brake {
    private Location location;
    private short axle;
    Integer temperature;
    TemperatureUnit temperatureUnit;
    Integer remainingBrakePad;
    DistanceUnit remainingBrakePadUnit;
}
