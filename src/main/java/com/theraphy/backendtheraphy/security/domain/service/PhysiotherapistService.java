package com.theraphy.backendtheraphy.security.domain.service;

import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PhysiotherapistService {
    List<Physiotherapist> getAll();
    Page<Physiotherapist> getAll(Pageable pageable);
    Physiotherapist getById(Long physiotherapistId);
    Physiotherapist create(Physiotherapist physiotherapist
    );

    Physiotherapist addAppointmentToPhysiotherapist(Long physiotherapistId, String patientName, String physiotherapistName,
                                                    String dateScheduled, Integer hour, Integer minute, String amPm, String topic, Boolean done, String diagnosis);
}
