package com.theraphy.backendtheraphy.security.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PhysiotherapistResource {
    private Long id;
    private Long user_id;
    private String first_name;
    private String paternal_surname;
    private String maternal_surname;
    private String specialization;
    private Integer  age;
    private String location;
    private String birthdate;
    private String  email;
    private Integer rating;
    private Integer  consultations_quantity;
    private String photo;
}
