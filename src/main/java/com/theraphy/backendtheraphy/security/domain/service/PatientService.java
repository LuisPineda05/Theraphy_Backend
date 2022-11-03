package com.theraphy.backendtheraphy.security.domain.service;

import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
    List<Patient> getAll();
    Page<Patient> getAll(Pageable pageable);
    Patient getById(Long patientId);
    Patient create(Patient patient);

    Patient addAppointmentToPatient(Long patientId, String patientName, String physiotherapistName,
                                    String dateScheduled, Integer hour, Integer minute, String amPm, String topic, Boolean done, String diagnosis);
}
