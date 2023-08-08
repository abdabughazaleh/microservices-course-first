package com.microservices.doctor.controller;

import com.microservices.doctor.model.dto.AddPatientDTO;
import com.microservices.doctor.model.dto.PatientDTO;
import com.microservices.doctor.service.DoctorPatientService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorPatientController {
    @Autowired
    private DoctorPatientService patientService;
    @CircuitBreaker(name = "getPatientInstance" , fallbackMethod = "getDefaultPatient")
    @GetMapping("/get-patient")
    public PatientDTO getPatient(@RequestParam Long id){
        return this.patientService.getPatient(id);
    }
    @PostMapping("/add-patient")
    public AddPatientDTO save(@RequestBody AddPatientDTO dto){
        return this.patientService.addPatient(dto);
    }

    public PatientDTO getDefaultPatient(Exception e){
        return PatientDTO.builder()
                .patientName("UNKNOWN-PATIENT")
                .id(0L)
                .patientAge(0)
                .build();
    }
}
