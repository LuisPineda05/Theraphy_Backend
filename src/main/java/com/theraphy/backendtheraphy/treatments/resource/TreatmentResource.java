package com.theraphy.backendtheraphy.treatments.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentResource {
    private Long id;
    private String title;
    private String description;
    private Integer sessionsQuantity;
    private Long physiotherapistId;
    private String photo;
    private String videoSessions;


}
