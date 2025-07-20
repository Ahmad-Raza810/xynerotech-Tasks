package com.xynerotech.task.doctor_appointment_booking_platform.exception;


//A custom exception class.
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
