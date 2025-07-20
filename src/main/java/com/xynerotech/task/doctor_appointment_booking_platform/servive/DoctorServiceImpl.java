package com.xynerotech.task.doctor_appointment_booking_platform.servive;

import com.xynerotech.task.doctor_appointment_booking_platform.dto.DoctorCreateDto;
import com.xynerotech.task.doctor_appointment_booking_platform.dto.DoctorUpdateDto;
import com.xynerotech.task.doctor_appointment_booking_platform.entity.Doctor;
import com.xynerotech.task.doctor_appointment_booking_platform.exception.ResourceNotFoundException;
import com.xynerotech.task.doctor_appointment_booking_platform.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;


    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    //service method for adding a new doctor.
    @Override
    public Doctor addDoctor(DoctorCreateDto createDoctorDto) {
        Doctor doctor=DoctorCreateDto.doctorCreateDtoToDoctor(createDoctorDto);
        return doctorRepository.save(doctor);
    }


    //service method for getting a doctor by id.
    @Override
    public Doctor getDoctorByID(Long doctorId) {
        return doctorRepository
                .findById(doctorId)
                .orElseThrow(()->new ResourceNotFoundException
                        ("Doctor with id '"+doctorId+"' not exists."));
    }


    //service method for getting all doctors.
    @Override
    public List<Doctor> getAllDoctor() {
        return  doctorRepository.findAll();
    }



    //service method for deleting an doctor.
    @Override
    public void deleteDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor with id '" + doctorId + "' not found."));

        doctorRepository.delete(doctor);
    }


    //service method for updating an doctor.
    @Override
    public DoctorUpdateDto updateDoctor(Long doctorId, DoctorUpdateDto updatedDoctor) {
        Doctor returnedDoctor = doctorRepository
                .findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor with id '" + doctorId + "' not exists."));

        boolean isAnyFieldUpdated = false;

        if (updatedDoctor.getName() != null && !updatedDoctor.getName().trim().isEmpty()) {
            returnedDoctor.setName(updatedDoctor.getName().trim());
            isAnyFieldUpdated = true;
        }

        if (updatedDoctor.getSpecialization() != null && !updatedDoctor.getSpecialization().trim().isEmpty()) {
            returnedDoctor.setSpecialization(updatedDoctor.getSpecialization().trim());
            isAnyFieldUpdated = true;
        }

        if (updatedDoctor.getContact() != null && !updatedDoctor.getContact().trim().isEmpty()) {
            returnedDoctor.setContact(updatedDoctor.getContact().trim());
            isAnyFieldUpdated = true;
        }

        if (!isAnyFieldUpdated) {
            throw new IllegalArgumentException("At least one field (name, specialization, or contact) must be provided for update.");
        }

        doctorRepository.save(returnedDoctor);

        return DoctorUpdateDto.doctorToDoctorUpdateDto(returnedDoctor);
    }


}
