package fses.fms.controller;

import fses.fms.model.Appointment;
import fses.fms.service.AppointmentService;
import fses.fms.validator.AppointmentValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fms")
@Api(description = "Appointment operations")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentValidator appointmentValidator;

    public AppointmentController(AppointmentService appointmentService,
                                 AppointmentValidator appointmentValidator) {
        this.appointmentService = appointmentService;
        this.appointmentValidator = appointmentValidator;
    }

    @RequestMapping(value = "/appointment", method = RequestMethod.POST)
    @ApiOperation(value = "Create an appointment")
    public ResponseEntity createAppointment(@RequestBody Appointment appointment, BindingResult bindingResult) {

        List<ObjectError> validationErrors = appointmentValidator.validate(RequestMethod.POST, appointment);
        if (bindingResult.hasErrors() || !validationErrors.isEmpty()) {
            validationErrors.addAll(bindingResult.getAllErrors());
            return new ResponseEntity(validationErrors, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.CREATED);

    }

    @RequestMapping(value = "/appointment/{fmsId}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update an appointment")
    public ResponseEntity updateAppointment(@PathVariable String fmsId, @RequestBody Appointment appointment, BindingResult bindingResult) {

        List<ObjectError> validationErrors = appointmentValidator.validate(RequestMethod.PUT, appointment);
        if (bindingResult.hasErrors() || !validationErrors.isEmpty()) {
            validationErrors.addAll(bindingResult.getAllErrors());
            return new ResponseEntity(validationErrors, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(value = "/appointment/{fmsId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete an appointment")
    public ResponseEntity deleteAppointment(@PathVariable String fmsId) {

        Appointment appointment = appointmentService.findOneById(fmsId);
        if (appointment == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity(HttpStatus.OK);


    }

}
