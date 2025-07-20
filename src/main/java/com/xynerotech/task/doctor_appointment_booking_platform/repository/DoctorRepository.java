package com.xynerotech.task.doctor_appointment_booking_platform.repository;

import com.xynerotech.task.doctor_appointment_booking_platform.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
