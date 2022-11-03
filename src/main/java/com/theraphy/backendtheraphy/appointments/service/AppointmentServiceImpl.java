package com.theraphy.backendtheraphy.appointments.service;

import com.theraphy.backendtheraphy.appointments.domain.model.entity.Appointment;
import com.theraphy.backendtheraphy.appointments.domain.persistence.AppointmentRepository;
import com.theraphy.backendtheraphy.appointments.domain.service.AppointmentService;
import com.theraphy.backendtheraphy.shared.exception.ResourceNotFoundException;
import com.theraphy.backendtheraphy.shared.exception.ResourceValidationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private static final String ENTITY = "Appointment";

    private final AppointmentRepository appointmentRepository;

    private final Validator validator;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, Validator validator) {
        this.appointmentRepository = appointmentRepository;
        this.validator = validator;
    }


    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public Appointment getByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("No Appointments with this id found for Patient"));
    }

    @Override
    public Appointment getByPhysiotherapistId(Long physiotherapistId) {
        return appointmentRepository.findByPhysiotherapistId(physiotherapistId)
                .orElseThrow(() -> new ResourceNotFoundException("No Appointments with this if found for Physiotherapist"));
    }

    @Override
    public Appointment create(Appointment appointment) {

        Set<ConstraintViolation<Appointment>> violations = validator.validate(appointment);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        return appointmentRepository.save(appointment);
    }

}
