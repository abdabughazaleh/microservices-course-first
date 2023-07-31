package com.microservices.patient.controller;

import com.microservices.patient.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PatientController {
    @Autowired
    private PatientService patientService;
    @GetMapping("/search/{name}")
    public String getName(@PathVariable("name") String name){
        log.info("new request : " + UUID.randomUUID());
        return this.patientService.getName(name);
    }
}
