package com.theraphy.backendtheraphy.security.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PhysiotherapistResource {
    private Long id;
    private Long userId;
    private String firstName;
    private String paternalSurname;
    private String maternalSurname;
    private String specialization;
    private Integer  age;
    private String location;
    private String birthdate;
    private String  email;
    private Integer rating;
    private Integer consultationsQuantity;
    private String photo;
}
