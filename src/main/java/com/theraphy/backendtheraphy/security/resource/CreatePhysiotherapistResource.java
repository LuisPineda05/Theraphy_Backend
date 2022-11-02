package com.theraphy.backendtheraphy.security.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePhysiotherapistResource {

    @NotNull
    private Long userId;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String paternalSurname;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String maternalSurname;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String specialization;

    @NotNull
    private Integer  age;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String location;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String birthdate;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String  email;

    @NotNull
    private Integer rating;

    @NotNull
    private Integer  consultationsQuantity;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String photo;
}
