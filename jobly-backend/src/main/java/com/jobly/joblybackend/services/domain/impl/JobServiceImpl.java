package com.jobly.joblybackend.services.domain.impl;

import com.jobly.joblybackend.exceptions.InvalidJobIdException;
import com.jobly.joblybackend.models.entities.Job;
import com.jobly.joblybackend.repositories.JobRepository;
import com.jobly.joblybackend.services.domain.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new InvalidJobIdException(id));
    }

    @Override
    public List<Job> getJobsByLocation(String location) {
        return jobRepository.findByLocationIgnoreCase(location);
    }

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public boolean existsByUrl(String url) {
        return jobRepository.existsByUrl(url);
    }

}
