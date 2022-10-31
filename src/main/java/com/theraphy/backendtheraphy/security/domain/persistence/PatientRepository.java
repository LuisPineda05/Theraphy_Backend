package com.theraphy.backendtheraphy.security.domain.persistence;

import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByFirstName(String name);
    Patient findByUserId(Long userId);
}
