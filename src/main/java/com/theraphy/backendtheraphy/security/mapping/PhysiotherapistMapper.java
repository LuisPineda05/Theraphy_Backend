package com.theraphy.backendtheraphy.security.mapping;

import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import com.theraphy.backendtheraphy.security.resource.CreatePatientResource;
import com.theraphy.backendtheraphy.security.resource.CreatePhysiotherapistResource;
import com.theraphy.backendtheraphy.security.resource.PatientResource;
import com.theraphy.backendtheraphy.security.resource.PhysiotherapistResource;
import com.theraphy.backendtheraphy.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class PhysiotherapistMapper implements Serializable{
    @Autowired
    EnhancedModelMapper mapper;

    public PhysiotherapistResource toResource(Physiotherapist model) {
        return mapper.map(model, PhysiotherapistResource.class);
    }

    public Physiotherapist toModel(CreatePhysiotherapistResource resource) {
        return mapper.map(resource, Physiotherapist.class);
    }

    public Page<PhysiotherapistResource> modelListPage(List<Physiotherapist> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PhysiotherapistResource.class), pageable, modelList.size());
    }
}