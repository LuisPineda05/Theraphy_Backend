package com.theraphy.backendtheraphy.appointments.domain.service;

import com.theraphy.backendtheraphy.appointments.domain.model.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface AppointmentService {
    List<Appointment> getAll();

   //Page<Appointment> getAll(Pageable pageable);

    Appointment getById(Long appointmentId);

    Appointment create(Appointment appointment);

    Appointment getByPhysiotherapistId(Long physiotherapistId);

    Appointment getByPatientId(Long physiotherapistId);

}
