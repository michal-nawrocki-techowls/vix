package fses.fms.service;

import fses.fms.model.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final Logger log = LoggerFactory.getLogger(AppointmentService.class);

    public Appointment save(Appointment appointment) {
        log.info("Appointment saved");
        return appointment;
    }
}
