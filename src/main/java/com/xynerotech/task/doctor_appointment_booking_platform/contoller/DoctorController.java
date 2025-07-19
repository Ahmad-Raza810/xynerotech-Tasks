package com.xynerotech.task.doctor_appointment_booking_platform.contoller;


import com.xynerotech.task.doctor_appointment_booking_platform.entity.Doctor;
import com.xynerotech.task.doctor_appointment_booking_platform.servive.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class DoctorController {

    private DoctorService doctorService;


    // Api endpoint for adding a new doctor.
    @PostMapping("/doctor")
    public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor){
        String response=doctorService.addDoctor(doctor);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Api endpoint for adding a new doctor.
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<Doctor> getDoctorByID(@PathVariable("doctorId") Long doctorId){
        Doctor returnedDoctor=doctorService.getDoctorByID(doctorId);
        return new ResponseEntity<>(returnedDoctor, HttpStatus.OK);
    }

    // Api endpoint for getting all  doctors.
    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctor(){
        List<Doctor> doctors=doctorService.getAllDoctor();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    // Api endpoint for updating an doctor.
    @PutMapping("/doctor/{doctorId}")
    public ResponseEntity<String> UpdateDoctor(@PathVariable("doctorId") Long doctorId,@RequestBody Doctor updatedDoctor){
        String response=doctorService.updateDoctor(doctorId,updatedDoctor);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
