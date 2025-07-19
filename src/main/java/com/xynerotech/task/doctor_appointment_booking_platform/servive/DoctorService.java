package com.xynerotech.task.doctor_appointment_booking_platform.servive;

import com.xynerotech.task.doctor_appointment_booking_platform.entity.Doctor;
import com.xynerotech.task.doctor_appointment_booking_platform.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DoctorService {

    String addDoctor(Doctor doctor);

    Doctor getDoctorByID(Long doctorId);

    List<Doctor> getAllDoctor();

    String deleteDoctor(Long doctorId);

    String updateDoctor(Long doctorId,Doctor updatedDoctor);



}
