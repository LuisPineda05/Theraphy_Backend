package com.theraphy.backendtheraphy.treatments.domain.service;


import com.theraphy.backendtheraphy.treatments.domain.model.entity.Treatment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TreatmentService {
    List<Treatment> getAll();
    Page<Treatment> getAll(Pageable pageable);
    Treatment getById(Long treatmentId);
    Treatment create(Treatment treatment);

}
