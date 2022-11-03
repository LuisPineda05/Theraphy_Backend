package com.theraphy.backendtheraphy.security.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.theraphy.backendtheraphy.appointments.domain.model.entity.Appointment;
import com.theraphy.backendtheraphy.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "physiotherapists")
public class Physiotherapist extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "paternal_surname")
    private String paternalSurname;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "maternal_surname")
    private String maternalSurname;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String specialization;

    private Integer  age;

    @NotNull
    @NotBlank
    private String location;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String birthdate;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String  email;


    private Integer rating;

    @Column(name = "consultations_quantity")
    private Integer  consultationsQuantity;

    @NotNull
    @NotBlank
    @Size(max = 500)
    private String photo;

    // Relationships

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, mappedBy = "physiotherapist")
    private Set<Appointment> appointments = new HashSet<>();

    public Physiotherapist addAppointment(String patientName, String physiotherapistName,
                                  String dateScheduled, Integer hour, Integer minute, String amPm, String topic, Boolean done, String diagnosis) {
        // Initialize if null
        if(appointments == null) {
            appointments = new HashSet<>();
        }


        // Add Appointment to Patient
        appointments.add(new Appointment()
                .withPhysiotherapistName(physiotherapistName)
                .withPatientName(patientName)
                .withDateScheduled(dateScheduled)
                .withDone(done)
                .withAmPm(amPm)
                .withMinute(minute)
                .withDiagnosis(diagnosis)
                .withHour(hour)
                .withTopic(topic)
                .withPhysiotherapist(this));

        return this;
    }
}
