package com.theraphy.backendtheraphy.appointments.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import com.theraphy.backendtheraphy.shared.domain.model.AuditModel;
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
@Entity
@Table(name = "appointments")
public class Appointment extends AuditModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "patient_id", nullable = true)
    @JsonIgnore
    private Patient patient;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String patientName;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "physiotherapist_id", nullable = true)
    @JsonIgnore
    private Physiotherapist physiotherapist;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String physiotherapistName;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String dateScheduled;

    @Max(24)
    private Integer hour;

    @Max(59)
    private Integer minute;

    @NotNull
    @NotBlank
    private String amPm;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String topic;

    @NotNull
    private Boolean done;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String diagnosis;




}
