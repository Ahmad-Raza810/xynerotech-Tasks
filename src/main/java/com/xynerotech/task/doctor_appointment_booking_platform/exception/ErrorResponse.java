package com.xynerotech.task.doctor_appointment_booking_platform.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private Integer statusCode;
    private LocalDateTime timestamp;


}
