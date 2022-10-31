package com.theraphy.backendtheraphy.security.api.rest;

import com.theraphy.backendtheraphy.security.domain.service.PhysiotherapistService;
import com.theraphy.backendtheraphy.security.mapping.PhysiotherapistMapper;
import com.theraphy.backendtheraphy.security.resource.CreatePatientResource;
import com.theraphy.backendtheraphy.security.resource.CreatePhysiotherapistResource;
import com.theraphy.backendtheraphy.security.resource.PatientResource;
import com.theraphy.backendtheraphy.security.resource.PhysiotherapistResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/physiotherapist", produces = "application/json")
public class PhysiotherapistController {

    private final PhysiotherapistService physiotherapistService;

    private final PhysiotherapistMapper mapper;

    public PhysiotherapistController(PhysiotherapistService physiotherapistService, PhysiotherapistMapper mapper) {
        this.physiotherapistService = physiotherapistService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<PhysiotherapistResource> getAllPhysiotherapist(Pageable pageable) {
        return mapper.modelListPage(physiotheapistService.getAll(), pageable);
    }

    @GetMapping("{physiotherapistId}")
    public PhysiotherapistResource getPhysiotherapistById(@PathVariable Long physiotherapistId) {
        return mapper.toResource(physiotheapistService.getById(physiotherapistId));
    }

    @PostMapping
    public ResponseEntity<PhysiotherapistResource> createPhysiotherapist(@RequestBody CreatePhysiotherapistResource resource) {
        return new ResponseEntity<>(mapper.toResource(physiotheapistService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
