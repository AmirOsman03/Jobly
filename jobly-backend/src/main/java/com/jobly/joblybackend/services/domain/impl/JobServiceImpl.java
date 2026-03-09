package com.jobly.joblybackend.services.domain.impl;

import com.jobly.joblybackend.exceptions.InvalidJobIdException;
import com.jobly.joblybackend.models.entities.Job;
import com.jobly.joblybackend.repositories.JobRepository;
import com.jobly.joblybackend.services.domain.JobService;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public Job save(Job job) {
        return jobRepository.findByUrl(job.getUrl())
                .map(existingJob -> {
                    existingJob.setTitle(job.getTitle());
                    existingJob.setCompany(job.getCompany());
                    existingJob.setLocation(job.getLocation());
                    existingJob.setSalary(job.getSalary());
                    existingJob.setSource(job.getSource());
                    existingJob.setValidUntil(job.getValidUntil());
                    return jobRepository.save(existingJob);
                })
                .orElseGet(() -> jobRepository.save(job));
    }

    @Override
    public boolean existsByUrl(String url) {
        return jobRepository.existsByUrl(url);
    }

}
