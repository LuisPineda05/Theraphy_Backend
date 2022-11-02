package com.theraphy.backendtheraphy.appointments.resource;

import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import com.theraphy.backendtheraphy.security.resource.PatientResource;
import com.theraphy.backendtheraphy.security.resource.PhysiotherapistResource;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResource {
    private Long id;
    private PatientResource patientId;
    private PhysiotherapistResource physiotherapistId;
    private String patientName;
    private String physiotherapistName;
    private String date;
    private Integer hour;
    private Integer minute;
    private String amPm;
    private String topic;
    private Boolean done;
    private String diagnosis;
}