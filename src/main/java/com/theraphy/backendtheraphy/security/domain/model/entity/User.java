package com.theraphy.backendtheraphy.security.domain.model.entity;

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
@Table(name = "users")
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(unique = true)
    private String email;


    @NotNull
    @NotBlank
    @Size(max = 60)
    private String password;

    @NotNull
    @NotBlank
    @Size(max = 15)
    private String type;
}
