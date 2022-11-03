package com.theraphy.backendtheraphy.security.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.theraphy.backendtheraphy.appointments.domain.model.entity.Appointment;
import com.theraphy.backendtheraphy.shared.domain.model.AuditModel;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "last_name")
    private String lastName;

    private Integer age;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String email;

    @NotNull
    @Column(name = "appointment_quantity")
    private Integer appointmentQuantity;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String photo;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String birthday;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    // Relationships

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, mappedBy = "patient")
    private Set<Appointment> appointments = new HashSet<>();

    public Patient addAppointment(String patientName, String physiotherapistName,
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
                .withPatient(this));

        return this;
    }
}


/* private Long id;
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

 */