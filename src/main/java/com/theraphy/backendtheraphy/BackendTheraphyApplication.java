package com.theraphy.backendtheraphy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class BackendTheraphyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendTheraphyApplication.class, args);
    }

}
