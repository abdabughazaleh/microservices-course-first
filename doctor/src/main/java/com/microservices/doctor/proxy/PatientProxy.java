package com.microservices.doctor.proxy;

import com.microservices.doctor.model.dto.AddPatientDTO;
import com.microservices.doctor.model.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "PATIENT-SERVICE" , path = "/patient")
public interface PatientProxy {
    @GetMapping("/get-patient")
    public PatientDTO get(@RequestParam Long id);
    @PostMapping("/add-patient")
    public AddPatientDTO save(@RequestBody AddPatientDTO dto);
}
