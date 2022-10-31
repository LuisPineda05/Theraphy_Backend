package com.theraphy.backendtheraphy.security.api.internal;

import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import com.theraphy.backendtheraphy.security.domain.model.entity.User;

import java.util.List;

public interface SecurityContextFacade {
    List<User> getAllUsers();
    List<Patient> getAllPatients();
    List<Physiotherapist> getAllPhysiotherapist();
}
