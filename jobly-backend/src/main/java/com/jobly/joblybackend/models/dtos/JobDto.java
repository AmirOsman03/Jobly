package com.jobly.joblybackend.models.dtos;

import java.time.LocalDate;
import java.util.List;

public record JobDto(
        String title,
        String company,
        String location,
        List<String> skills,
        String source,
        LocalDate validUntil
) {}
