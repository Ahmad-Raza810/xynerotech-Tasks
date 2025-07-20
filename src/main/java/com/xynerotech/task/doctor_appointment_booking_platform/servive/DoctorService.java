package com.xynerotech.task.doctor_appointment_booking_platform.servive;

import com.xynerotech.task.doctor_appointment_booking_platform.dto.DoctorCreateDto;
import com.xynerotech.task.doctor_appointment_booking_platform.dto.DoctorUpdateDto;
import com.xynerotech.task.doctor_appointment_booking_platform.entity.Doctor;
import com.xynerotech.task.doctor_appointment_booking_platform.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DoctorService {

    Doctor addDoctor(DoctorCreateDto doctor);

    Doctor getDoctorByID(Long doctorId);

    List<Doctor> getAllDoctor();

    void deleteDoctor(Long doctorId);

    DoctorUpdateDto updateDoctor(Long doctorId, DoctorUpdateDto updatedDoctor);



}
