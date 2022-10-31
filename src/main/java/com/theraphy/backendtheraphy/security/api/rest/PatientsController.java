package com.theraphy.backendtheraphy.security.api.rest;


import com.theraphy.backendtheraphy.security.domain.service.PatientService;
import com.theraphy.backendtheraphy.security.mapping.PatientMapper;
import com.theraphy.backendtheraphy.security.resource.CreatePatientResource;
import com.theraphy.backendtheraphy.security.resource.CreateUserResource;
import com.theraphy.backendtheraphy.security.resource.PatientResource;
import com.theraphy.backendtheraphy.security.resource.UserResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/patients", produces = "application/json")
public class PatientsController {

    private final PatientService patientService;

    private final PatientMapper mapper;

    public PatientsController(PatientService patientService, PatientMapper mapper) {
        this.patientService = patientService;
        this.mapper = mapper;
    }


    @GetMapping
    public Page<PatientResource> getAllPatients(Pageable pageable) {
        return mapper.modelListPage(patientService.getAll(), pageable);
    }

    @GetMapping("{patientId}")
    public PatientResource getPatientById(@PathVariable Long patientId) {
        return mapper.toResource(patientService.getById(patientId));
    }

    @PostMapping
    public ResponseEntity<PatientResource> createPatient(@RequestBody CreatePatientResource resource) {
        return new ResponseEntity<>(mapper.toResource(patientService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
