package com.jobly.joblybackend.exceptions;

public class InvalidJobIdException extends RuntimeException {
    public InvalidJobIdException(Long id) {
        super("Job with id " + id + " not found");
    }
}
