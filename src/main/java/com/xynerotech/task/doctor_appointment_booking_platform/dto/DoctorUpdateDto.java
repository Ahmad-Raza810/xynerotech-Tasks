package com.xynerotech.task.doctor_appointment_booking_platform.dto;

import com.xynerotech.task.doctor_appointment_booking_platform.entity.Doctor;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorUpdateDto {
    private Long id;

    @Pattern(regexp = ".*\\S.*", message = "Name must not be blank.")
    private String name;

    @Pattern(regexp = ".*\\S.*", message = "Specialization must not be blank.")
    private String specialization;

    @Pattern(regexp = "^[0-9]{10}$", message = "Contact must be a valid 10-digit number.")
    private String contact;


    // Method for converting doctorUpdateDto object into doctor object.
    public static DoctorUpdateDto doctorToDoctorUpdateDto(Doctor doctor){
        DoctorUpdateDto doctorUpdateDto=new DoctorUpdateDto();
        doctorUpdateDto.setId(doctor.getId());
        doctorUpdateDto.setName(doctor.getName());
        doctorUpdateDto.setSpecialization(doctor.getSpecialization());
        doctorUpdateDto.setContact(doctor.getContact());
        return doctorUpdateDto;
    }
}
