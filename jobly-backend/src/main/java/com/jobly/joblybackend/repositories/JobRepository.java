package com.jobly.joblybackend.repositories;

import com.jobly.joblybackend.models.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    boolean existsByUrl(String url);

    List<Job> findByLocationIgnoreCase(String location);

    Optional<Job> findByUrl(String url);

}
