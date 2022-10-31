package com.theraphy.backendtheraphy.security.resource;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
public class CreatePhysiotherapistResource {

    @NotNull
    private Long user_id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String first_name;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String paternal_surname;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String maternal_surname;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String specialization;

    @NotNull
    @NotBlank
    @Size(max = 60)
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
    @NotBlank
    @Size(max = 60)
    private Integer rating;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private Integer  consultations_quantity;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String photo;
}
