package com.xynerotech.task.doctor_appointment_booking_platform.contoller;


import com.xynerotech.task.doctor_appointment_booking_platform.entity.Doctor;
import com.xynerotech.task.doctor_appointment_booking_platform.servive.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Api endpoint for adding a new doctor.
    @PostMapping("/doctor")
    public ResponseEntity<String> addDoctor(@Valid @RequestBody Doctor doctor){
        String response=doctorService.addDoctor(doctor);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Api endpoint for getting a doctor by id.
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

    // Api endpoint for updating a doctor.
    @PutMapping("/doctor/{doctorId}")
    public ResponseEntity<String> UpdateDoctor( @PathVariable("doctorId") Long doctorId,@Valid @RequestBody Doctor updatedDoctor){
        String response=doctorService.updateDoctor(doctorId,updatedDoctor);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
