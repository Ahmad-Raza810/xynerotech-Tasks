package com.xynerotech.task.doctor_appointment_booking_platform.servive;

import com.xynerotech.task.doctor_appointment_booking_platform.dto.DoctorCreateDto;
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

    @Override
    public String deleteDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);
        return "doctor deleted successfully.";
    }

    //service method for updating doctor.
    @Override
    public String updateDoctor(Long doctorId, Doctor updatedDoctor) {
       Doctor returnedDoctor=doctorRepository
                .findById(doctorId)
                .orElseThrow(()-> new ResourceNotFoundException
                        ("Doctor with id '"+doctorId+"' not exists."));

       if(updatedDoctor.getName()!=null)
         returnedDoctor.setName(updatedDoctor.getName());

       if(updatedDoctor.getSpecialization()!=null)
           returnedDoctor.setSpecialization(updatedDoctor.getSpecialization());

        if(updatedDoctor.getContact()!=null)
           returnedDoctor.setContact(updatedDoctor.getContact());

        doctorRepository.save(returnedDoctor);
        return "Doctor successfully updated";
    }

}
