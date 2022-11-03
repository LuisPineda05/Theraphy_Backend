package com.theraphy.backendtheraphy.security.domain.persistence;

import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysiotherapistRepository extends JpaRepository<Physiotherapist, Long> {
    Physiotherapist findByFirstName(String name);
    Physiotherapist findByUserId(Long userId);

}
