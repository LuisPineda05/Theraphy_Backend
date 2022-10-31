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
    private Long user_id;
    private String first_name;
    private String last_name;
    private Integer age;
    private String birthday;
    private String email;
    private Integer appointment_quantity;
    private String photo;

}
