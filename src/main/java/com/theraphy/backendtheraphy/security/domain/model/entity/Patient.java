package com.theraphy.backendtheraphy.security.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.theraphy.backendtheraphy.shared.domain.model.AuditModel;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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
    @NotBlank
    @Size(max = 60)
    @Column(name = "appointment_quantity")
    private Integer appointmentQuantity;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String photo;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;
}
