package com.xynerotech.task.doctor_appointment_booking_platform.dto;

import com.xynerotech.task.doctor_appointment_booking_platform.entity.Doctor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorCreateDto {

    private Long id;

    @NotBlank(message = "Name is required.")
    private String name;

    @NotBlank(message = "Specialization is required.")
    private String specialization;

    @NotBlank(message = "Contact is required.")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact must be a valid 10-digit number.")
    private String contact;

// Method for converting doctorCreateDto object into doctor object.
    public static Doctor doctorCreateDtoToDoctor(DoctorCreateDto doctorCreateDto){
        Doctor doctor=new Doctor();
        doctor.setName(doctorCreateDto.getName());
        doctor.setSpecialization(doctorCreateDto.getSpecialization());
        doctor.setContact(doctorCreateDto.getContact());
        return doctor;
    }

    //Method for converting doctor  object into doctorCreateDto object.
    public static DoctorCreateDto doctorToDoctorCreateDto(Doctor doctor){
       DoctorCreateDto doctorCreateDto=new DoctorCreateDto();
       doctorCreateDto.setName(doctor.getName());
       doctorCreateDto.setSpecialization(doctor.getSpecialization());
       doctorCreateDto.setContact(doctor.getContact());
       doctorCreateDto.setId(doctor.getId());

       return doctorCreateDto;
    }

}
