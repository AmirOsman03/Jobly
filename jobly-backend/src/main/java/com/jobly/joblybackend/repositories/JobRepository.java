package com.jobly.joblybackend.repositories;

import com.jobly.joblybackend.models.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    boolean existsByUrl(String url);

    List<Job> findByLocationIgnoreCase(String location);

    List<Job> findByCompanyIgnoreCase(String company);

}
