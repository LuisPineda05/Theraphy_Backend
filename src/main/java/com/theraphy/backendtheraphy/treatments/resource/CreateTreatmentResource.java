package com.theraphy.backendtheraphy.treatments.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateTreatmentResource {

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String title;

    @NotNull
    @NotBlank
    @Size(max = 240)
    private String description;

    @NotNull
    private Long physiotherapistId;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String photo;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String videoSessions;


}
