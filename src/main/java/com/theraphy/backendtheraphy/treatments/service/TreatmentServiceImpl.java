package com.theraphy.backendtheraphy.treatments.service;

import com.theraphy.backendtheraphy.treatments.domain.model.entity.Treatment;
import com.theraphy.backendtheraphy.treatments.domain.persistence.TreatmentRepository;
import com.theraphy.backendtheraphy.treatments.domain.service.TreatmentService;
import org.springframework.stereotype.Service;

import javax.validation.Validator;

@Service
public class TreatmentServiceImpl implements TreatmentService{

    private static final String ENTITY = "Treatment";

    private final TreatmentRepository treatmentRepository;

    private final Validator validator;

    public TreatmentServiceImpl(TreatmentRepository treatmentRepository, Validator validator) {
        this.treatmentRepository = treatmentRepository;
        this.validator = validator;
    }

    @Override
    public List<Treatment> getAll() {
        return treatmentRepository.findAll();
    }

    @Override
    public Page<Treatment> getAll(Pageable pageable) {
        return treatmentRepository.findAll(pageable);
    }

    @Override
    public Treatment getById(Long treatmentId) {
        return treatmentRepository.findById(treatmentId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, treatmentId));
    }

    @Override
    public Treatment create(Treatment treatment) {

        Set<ConstraintViolation<Treatment>> violations = validator.validate(treatment);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);



        return treatmentRepository.save(treatment);
    }
}
