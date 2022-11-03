package com.theraphy.backendtheraphy.appointments.api.rest;


import com.theraphy.backendtheraphy.appointments.domain.service.AppointmentService;
import com.theraphy.backendtheraphy.appointments.mapping.AppointmentMapper;
import com.theraphy.backendtheraphy.appointments.resource.AppointmentResource;
import com.theraphy.backendtheraphy.appointments.resource.CreateAppointmentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/appointments", produces = "application/json")
public class AppointmentsController {

    private final AppointmentService appointmentService;

    private final AppointmentMapper mapper;

    public AppointmentsController(AppointmentService appointmentService, AppointmentMapper mapper) {
        this.appointmentService = appointmentService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<AppointmentResource> getAllAppointments(Pageable pageable) {
        return mapper.modelListPage(appointmentService.getAll(), pageable);
    }

    @GetMapping("{appointmentId}")
    public AppointmentResource getAppointmentById(@PathVariable Long appointmentId) {
        return mapper.toResource(appointmentService.getById(appointmentId));
    }

    @PostMapping
    public ResponseEntity<AppointmentResource> createAppointment(@RequestBody CreateAppointmentResource resource) {
        return new ResponseEntity<>(mapper.toResource(appointmentService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

}
