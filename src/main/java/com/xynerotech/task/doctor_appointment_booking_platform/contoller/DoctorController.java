package com.xynerotech.task.doctor_appointment_booking_platform.contoller;


import com.xynerotech.task.doctor_appointment_booking_platform.dto.DoctorCreateDto;
import com.xynerotech.task.doctor_appointment_booking_platform.dto.DoctorResponseDto;
import com.xynerotech.task.doctor_appointment_booking_platform.dto.DoctorUpdateDto;
import com.xynerotech.task.doctor_appointment_booking_platform.entity.Doctor;
import com.xynerotech.task.doctor_appointment_booking_platform.response.ApiResponse;
import com.xynerotech.task.doctor_appointment_booking_platform.servive.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/")
@Validated
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Api endpoint for adding a new doctor.
    @PostMapping("/doctor")
    public ResponseEntity<ApiResponse<DoctorCreateDto>> addDoctor(@Valid @RequestBody DoctorCreateDto doctorCreateDto){
        Doctor doctor=doctorService.addDoctor(doctorCreateDto);
        ApiResponse<DoctorCreateDto> response=new ApiResponse<>(
                "Doctor created successfully.",
                DoctorCreateDto.doctorToDoctorCreateDto(doctor),
                LocalDateTime.now(),
                HttpStatus.CREATED.value()
        );
        return new ResponseEntity<ApiResponse<DoctorCreateDto>>(response, HttpStatus.CREATED);
    }



    // Api endpoint for getting a doctor by id.
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<ApiResponse<DoctorResponseDto>> getDoctorByID(@PathVariable("doctorId") Long doctorId){
        Doctor returnedDoctor=doctorService.getDoctorByID(doctorId);
        DoctorResponseDto doctorResponseDto=DoctorResponseDto.doctorToDoctorResponseDto(returnedDoctor);

        ApiResponse<DoctorResponseDto> response=new ApiResponse<>(
                "Doctor fetched successfully.",
                doctorResponseDto,
                LocalDateTime.now(),
                HttpStatus.OK.value()
                );
       return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // Api endpoint for getting all  doctors.
    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorResponseDto>> getAllDoctor(){
        List<Doctor> doctors=doctorService.getAllDoctor();
        List<DoctorResponseDto> doctorResponses=doctors.stream().map(DoctorResponseDto::doctorToDoctorResponseDto).toList();
        return new ResponseEntity<>(doctorResponses, HttpStatus.OK);
    }



    // Api endpoint for updating a doctor.
    @PutMapping("/doctor/{doctorId}")
    public ResponseEntity<ApiResponse<DoctorUpdateDto>> updateDoctor( @PathVariable("doctorId") Long doctorId,@Valid @RequestBody DoctorUpdateDto updatedDoctor){
        DoctorUpdateDto doctorUpdateDto=doctorService.updateDoctor(doctorId,updatedDoctor);
        ApiResponse<DoctorUpdateDto> response=new ApiResponse<>(
                "Doctor details updated successfully.",
                doctorUpdateDto,
                LocalDateTime.now(),
                HttpStatus.OK.value());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // API endpoint for deleting a doctor by ID
    @DeleteMapping("/doctor/{doctorId}")
    public ResponseEntity<ApiResponse<Void>> deleteDoctor(@PathVariable("doctorId") Long doctorId) {
        doctorService.deleteDoctor(doctorId); // Delegate deletion to service layer

        ApiResponse<Void> response = new ApiResponse<>(
                "Doctor deleted successfully.",
                null,
                LocalDateTime.now(),
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
