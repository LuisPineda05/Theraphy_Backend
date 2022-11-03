package com.theraphy.backendtheraphy.appointments.api.internal;

import com.theraphy.backendtheraphy.appointments.domain.model.entity.Appointment;

import java.util.List;

public interface AppointmentsContextFacade {
    List<Appointment> getAllAppointments();
}
