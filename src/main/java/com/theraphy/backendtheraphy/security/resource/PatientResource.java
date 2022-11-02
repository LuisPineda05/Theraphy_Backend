package com.theraphy.backendtheraphy.security.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PatientResource {
    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String birthday;
    private String email;
    private Integer appointmentQuantity;
    private String photo;

}
