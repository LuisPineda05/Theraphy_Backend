package com.theraphy.backendtheraphy.treatments.api.internal;

import com.theraphy.backendtheraphy.treatments.domain.model.entity.Treatment;

import java.util.List;

public interface TreatmentsContextFacade {

    List<Treatment> getAllTreatments();

}
