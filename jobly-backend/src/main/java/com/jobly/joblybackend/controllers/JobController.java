package com.jobly.joblybackend.controllers;

import com.jobly.joblybackend.models.entities.Job;
import com.jobly.joblybackend.services.domain.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAllJobs(
            @RequestParam(required = false) String location
    ) {
        if (location != null) {
            return jobService.getJobsByLocation(location);
        }
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @PostMapping
    public Job saveJob(@RequestBody Job job) {
        return jobService.save(job);
    }

}
