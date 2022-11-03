package com.theraphy.backendtheraphy.appointments.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import com.theraphy.backendtheraphy.security.resource.PatientResource;
import com.theraphy.backendtheraphy.security.resource.PhysiotherapistResource;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResource {
    private Long id;
    private PatientResource patient;
    private String patientName;
    private PhysiotherapistResource physiotherapist;
    private String physiotherapistName;
    private String dateScheduled;
    private Integer hour;
    private Integer minute;
    private String amPm;
    private String topic;
    private Boolean done;
    private String diagnosis;
}
