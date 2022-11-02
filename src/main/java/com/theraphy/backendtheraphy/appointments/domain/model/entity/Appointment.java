package com.theraphy.backendtheraphy.appointments.domain.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import com.theraphy.backendtheraphy.shared.domain.model.AuditModel;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnore
    private Patient patient;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "patient_name")
    private String patientName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "physiotherapist_id", nullable = false)
    @JsonIgnore
    private Physiotherapist physiotherapistId;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "physiotherapist_name")
    private String physiotherapistName;

    @NotNull
    private Date date;

    @Max(24)
    private Integer hour;

    @Max(60)
    private Integer minute;

    @NotNull
    @NotBlank
    @Column(name = "am_pm")
    private String amPm;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String topic;

    private Boolean done;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String diagnosis;
}

