package com.microservices.patient.controller;

import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.model.dto.PatientDTO;
import com.microservices.patient.model.dto.PaymentDTO;
import com.microservices.patient.model.dto.UpdatePatientDTO;
import com.microservices.patient.service.PatientPaymentService;
import com.microservices.patient.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientPaymentService paymentService;
    @PostMapping("/add-patient")
    public AddPatientDTO save(@RequestBody AddPatientDTO dto){
        return this.patientService.save(dto);
    }
    @PutMapping("/update-patient")
    public PatientDTO update(@RequestBody UpdatePatientDTO dto){
        return this.patientService.update(dto);
    }
    @DeleteMapping("/delete-patient")
    public void delete(@RequestParam Long id){
         this.patientService.delete(id);
    }
    @GetMapping("/get-patient")
    public PatientDTO get(@RequestParam Long id){
         return this.patientService.get(id);
    }
    @GetMapping("/get-patient-payments")
    public List<PaymentDTO> getPatientPayments(@RequestHeader Long id){
        return this.paymentService.getPatientPayments(id);
    }
}
