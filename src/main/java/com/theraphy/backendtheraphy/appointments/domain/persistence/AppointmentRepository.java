package com.theraphy.backendtheraphy.appointments.domain.persistence;

import com.theraphy.backendtheraphy.appointments.domain.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByPatientId(Long patientId);

    List<Appointment> findByPatientName(String patientName);

    Optional<Appointment> findByPhysiotherapistId(Long physiotherapistId);

    List<Appointment> findByPhysiotherapistName(String physiotherapistName);

    List<Appointment> findByDone(Boolean done);

}
