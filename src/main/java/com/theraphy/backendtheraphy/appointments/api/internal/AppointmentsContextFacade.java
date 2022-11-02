package com.theraphy.backendtheraphy.appointments.api.internal;

import com.theraphy.backendtheraphy.appointments.domain.model.entity.Appointment;
import com.theraphy.backendtheraphy.treatments.domain.model.entity.Treatment;

import java.util.List;

public interface AppointmentsContextFacade {
    List<Appointment> getAllAppointments();

}
