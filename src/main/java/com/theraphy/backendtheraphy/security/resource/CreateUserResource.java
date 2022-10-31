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
public class CreateUserResource {

    @NotNull
    @NotBlank
    @Size(max = 60)
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
