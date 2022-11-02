package com.theraphy.backendtheraphy.appointments.domain.persistence;

import com.theraphy.backendtheraphy.appointments.domain.model.entity.Appointment;
import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    //Appointment findByPatientId(Long patientId);

    Appointment findByPatientName(String patientName);

    //Appointment findByPhysiotherapistId(Long physiotherapistId);

    Appointment findByPhysiotherapistName(String physiotherapistName);

    Appointment findByDone(Boolean done);

}
