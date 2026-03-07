package com.jobly.joblybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JoblyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoblyBackendApplication.class, args);
    }

}
