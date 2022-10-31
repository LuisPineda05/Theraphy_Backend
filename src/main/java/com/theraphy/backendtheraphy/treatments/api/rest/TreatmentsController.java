package com.theraphy.backendtheraphy.treatments.api.rest;

import com.theraphy.backendtheraphy.treatments.domain.service.TreatmentService;
import com.theraphy.backendtheraphy.treatments.mapping.TreatmentMapper;
import com.theraphy.backendtheraphy.treatments.resource.CreateTreatmentResource;
import com.theraphy.backendtheraphy.treatments.resource.TreatmentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/treatments", produces = "application/json")
public class TreatmentsController {

    private final TreatmentService treatmentService;

    private final TreatmentMapper mapper;

    public TreatmentsController(TreatmentService treatmentService,  TreatmentMapper mapper) {
        this.treatmentService = treatmentService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<TreatmentResource> getAllTreatments(Pageable pageable) {
        return mapper.modelListPage(treatmentService.getAll(), pageable);
    }

    @GetMapping("{treatmentId}")
    public TreatmentResource getTreatmentById(@PathVariable Long treatmentId) {
        return mapper.toResource(treatmentService.getById(treatmentId));
    }

    @PostMapping
    public ResponseEntity<TreatmentResource> createTreatment(@RequestBody CreateTreatmentResource resource) {
        return new ResponseEntity<>(mapper.toResource(treatmentService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }


}
