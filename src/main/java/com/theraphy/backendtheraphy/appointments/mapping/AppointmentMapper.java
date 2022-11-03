package com.theraphy.backendtheraphy.appointments.mapping;

import com.theraphy.backendtheraphy.appointments.domain.model.entity.Appointment;
import com.theraphy.backendtheraphy.appointments.resource.AppointmentResource;
import com.theraphy.backendtheraphy.appointments.resource.CreateAppointmentResource;
import com.theraphy.backendtheraphy.shared.mapping.EnhancedModelMapper;
import com.theraphy.backendtheraphy.treatments.domain.model.entity.Treatment;
import com.theraphy.backendtheraphy.treatments.resource.CreateTreatmentResource;
import com.theraphy.backendtheraphy.treatments.resource.TreatmentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class AppointmentMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public AppointmentResource toResource(Appointment model) {
        return mapper.map(model, AppointmentResource.class);
    }

    public Appointment toModel(CreateAppointmentResource resource) {
        return mapper.map(resource, Appointment.class);
    }

    public Page<AppointmentResource> modelListPage(List<Appointment> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, AppointmentResource.class), pageable, modelList.size());
    }

}
