package com.xynerotech.task.doctor_appointment_booking_platform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is required.")
    private String name;

    @NotBlank(message = "specialization is required.")
    private String specialization;

    @NotBlank(message = "contact is required")
    @Pattern(regexp = "^[0-9]{10}$" ,message = "contact must be a valid 10 digit number.")
    private String contact;
}
