package com.theraphy.backendtheraphy.appointments.api.rest;

import com.theraphy.backendtheraphy.appointments.domain.service.AppointmentService;
import com.theraphy.backendtheraphy.appointments.mapping.AppointmentMapper;
import com.theraphy.backendtheraphy.appointments.resource.AppointmentResource;
import com.theraphy.backendtheraphy.appointments.resource.CreateAppointmentResource;
import com.theraphy.backendtheraphy.security.domain.service.PatientService;
import com.theraphy.backendtheraphy.security.domain.service.PhysiotherapistService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/{physiotherapistId}/{patientId}/appointments", produces = "application/json")
//@Tag(name = "Physiotherapists", description = "Create, read, update and delete physiotherapist")
//@Tag(name = "Patients", description = "Create, read, update and delete patients")
public class PatientPhysiotherapistAppointmentsController {

    private final AppointmentService appointmentService;

    private final PhysiotherapistService physiotherapistService;

    private final PatientService patientService;

    private final AppointmentMapper mapper;

    public PatientPhysiotherapistAppointmentsController(AppointmentService appointmentService, PhysiotherapistService physiotherapistService,
                                                        AppointmentMapper mapper, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.physiotherapistService = physiotherapistService;
        this.patientService = patientService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<AppointmentResource> getAllAppointmentByPatientId(@PathVariable Long patientId, Pageable pageable) {
        return mapper.modelListPage(patientService.getById(patientId)
                .getAppointments().stream().toList(), pageable);
    }

/*
    @GetMapping
    public Page<AppointmentResource> getAllAppointmentByPhysiotherapistId(@PathVariable Long physiotherapistId, Pageable pageable) {
        return mapper.modelListPage(physiotherapistService.getById(physiotherapistId)
                .getAppointments().stream().toList(), pageable);
    }


*/


    @PostMapping
    public AppointmentResource createAppointment(@PathVariable Long physiotherapistId,
                                             @PathVariable Long patientId,
                                             @RequestBody CreateAppointmentResource resource) {

        //patientService.getById(patientId);
        // physiotherapistService.getById(physiotherapistId)


        physiotherapistService.addAppointmentToPhysiotherapist(physiotherapistId,resource.getPatientName(),resource.getPhysiotherapistName(),resource.getDateScheduled(),
                resource.getHour(),resource.getMinute(),resource.getAmPm(),resource.getTopic(),resource.isDone(),resource.getDiagnosis());


        patientService.addAppointmentToPatient(patientId, resource.getPatientName(),resource.getPhysiotherapistName(),resource.getDateScheduled(),
                resource.getHour(),resource.getMinute(),resource.getAmPm(),resource.getTopic(),resource.isDone(),resource.getDiagnosis());



        return mapper.toResource(appointmentService
                .getByPatientId(patientId));
    }
}
