package com.theraphy.backendtheraphy.treatments.domain.model.entity;

import com.theraphy.backendtheraphy.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "treatments")
public class Treatment extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String title;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String description;

    private Integer sessionsQuantity;

    @NotNull
    @Column(name = "physiotherapist_id")
    private Long physiotherapistId;

    @NotNull
    @NotBlank
    @Size(max = 240)
    private String photo;

    @NotNull
    @NotBlank
    @Size(max = 240)
    private String videoSessions;

}
