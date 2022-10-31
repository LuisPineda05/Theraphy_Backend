package com.theraphy.backendtheraphy.security.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.theraphy.backendtheraphy.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "physiotherapist")
public class Physiotherapist extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "first_name")
    private String first_name;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "paternal_surname")
    private String paternal_surname;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "maternal_surname")
    private String maternal_surname;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "specialization")
    private String specialization;

    private Integer  age;

    @NotNull
    @NotBlank
    @Column(name = "last_name")
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

    private Integer  consultations_quantity;

    @NotNull
    @NotBlank
    @Size(max = 500)
    private String photo;
}
