package com.jobly.joblybackend.services.domain;


import com.jobly.joblybackend.models.entities.Job;

import java.util.List;

public interface JobService {

    List<Job> getAllJobs();

    Job getJobById(Long id);

    List<Job> getJobsByLocation(String location);

    Job save(Job job);

    boolean existsByUrl(String url);

}
