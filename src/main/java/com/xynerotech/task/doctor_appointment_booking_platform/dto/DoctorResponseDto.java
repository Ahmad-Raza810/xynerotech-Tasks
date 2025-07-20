package com.xynerotech.task.doctor_appointment_booking_platform.dto;

import com.xynerotech.task.doctor_appointment_booking_platform.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponseDto {
    private Long id;
    private String name;
    private String specialization;
    private String contact;


    //Method for converting doctor  object into doctorResponseDto object.
    public static DoctorResponseDto doctorToDoctorResponseDto(Doctor doctor){
        DoctorResponseDto doctorResponseDto=new DoctorResponseDto();
        doctorResponseDto.setId(doctor.getId());
        doctorResponseDto.setName(doctor.getName());
        doctorResponseDto.setSpecialization(doctor.getSpecialization());
        doctorResponseDto.setContact(doctor.getContact());

        return doctorResponseDto;
    }

}
