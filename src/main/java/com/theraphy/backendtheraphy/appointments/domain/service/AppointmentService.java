package com.theraphy.backendtheraphy.appointments.domain.service;

import com.theraphy.backendtheraphy.appointments.domain.model.entity.Appointment;
import com.theraphy.backendtheraphy.treatments.domain.model.entity.Treatment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAll();
    Page<Appointment> getAll(Pageable pageable);
    Appointment getById(Long appointmentId);
    Appointment create(Appointment appointment);
}
