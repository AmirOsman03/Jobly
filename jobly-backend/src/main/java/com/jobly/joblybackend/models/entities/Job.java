package com.jobly.joblybackend.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "jobs")
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String company;

    private String location;

    private String salary;

    private String source;

    private LocalDate validUntil;

    private String url;

    public Job() {}

    public Job(
            String title,
            String company,
            String location,
            String salary,
            String source,
            LocalDate validUntil,
            String url
    ) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.salary = salary;
        this.source = source;
        this.validUntil = validUntil;
        this.url = url;
    }
}
