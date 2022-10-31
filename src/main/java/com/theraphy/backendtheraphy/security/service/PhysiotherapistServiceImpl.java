package com.theraphy.backendtheraphy.security.service;

import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import com.theraphy.backendtheraphy.security.domain.persistence.PhysiotherapistRepository;
import com.theraphy.backendtheraphy.security.domain.service.PhysiotherapistService;
import com.theraphy.backendtheraphy.shared.exception.ResourceNotFoundException;
import com.theraphy.backendtheraphy.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PhysiotherapistServiceImpl implements PhysiotherapistService {
    private static final String ENTITY = "Physiotherapist";

    private final PhysiotherapistRepository physiotherapistRepository;

    private final Validator validator;

    public PhysiotherapistServiceImpl(PhysiotherapistRepository physiotherapistRepository, Validator validator) {
        this.physiotherapistRepository = physiotherapistRepository;
        this.validator = validator;
    }

    @Override
    public List<Physiotherapist> getAll() {
        return physiotherapistRepository.findAll();
    }

    @Override
    public Page<Physiotherapist> getAll(Pageable pageable) {
        return physiotherapistRepository.findAll(pageable);
    }

    @Override
    public Physiotherapist getById(Long physiotherapistId) {
        return this.physiotherapistRepository.findById(physiotherapistId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, physiotherapistId));
    }

    @Override
    public Physiotherapist create(Physiotherapist physiotherapist) {

        Set<ConstraintViolation<Physiotherapist>> violations = validator.validate(physiotherapist);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        return physiotherapistRepository.save(physiotherapist);
    }
}
