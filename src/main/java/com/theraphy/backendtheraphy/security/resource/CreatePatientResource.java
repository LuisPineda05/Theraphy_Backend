package com.theraphy.backendtheraphy.security.resource;


import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientResource {
    @NotNull
    @NotBlank
    @Size(max = 60)
    private String first_name;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String last_name;

    @Min(18)
    private Integer age;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String birthday;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private Integer appointment_quantity;

    @NotNull
    private Long user_id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String photo;
}
