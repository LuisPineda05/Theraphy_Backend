package com.theraphy.backendtheraphy.appointments.mapping;

import com.theraphy.backendtheraphy.appointments.domain.model.entity.Appointment;
import com.theraphy.backendtheraphy.treatments.mapping.TreatmentMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration("appointmentsMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public AppointmentMapper appointmentMapper() { return new AppointmentMapper();}

}
