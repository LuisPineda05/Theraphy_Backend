package com.theraphy.backendtheraphy.appointments.resource;

import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateAppointmentResource {

    @NotNull
    @NotBlank
    @Size(max = 240)
    private String patientName;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String physiotherapistName;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String dateScheduled;

    @NotNull
    private Integer hour;

    @NotNull
    private Integer minute;


    @NotNull
    @NotBlank
    @Size(max = 50)
    private String amPm;

    @NotNull
    @NotBlank
    @Size(max = 240)
    private String diagnosis;

    @NotNull
    private boolean done;

    @NotNull
    @NotBlank
    @Size(max = 240)
    private String topic;

}
