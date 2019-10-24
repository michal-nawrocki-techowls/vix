package fses.fms.validator;

import fses.fms.model.Appointment;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AppointmentValidator {

    public List<ObjectError> validate(RequestMethod post, Appointment appointment) {
        List<ObjectError> errors = new ArrayList<>();
        switch (post) {
            case POST:
                errors.addAll(this.create(appointment));
                break;

            case PUT:
                errors.addAll(this.update(appointment));
                break;

            default:
                errors.add(new ObjectError("RequestMethod", "RequestMethod not supported"));
        }
        return errors;
    }

    private Collection<? extends ObjectError> create(Appointment appointment) {
        List<ObjectError> errors = new ArrayList<>();
        return errors;
    }

    private Collection<? extends ObjectError> update(Appointment appointment) {
        List<ObjectError> errors = new ArrayList<>();
        return errors;
    }

}

