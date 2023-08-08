package com.microservices.patient.proxy;

import com.microservices.patient.model.dto.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "PAYMENT-SERVICE" , path = "/payment")
public interface PaymentProxy {
    @GetMapping("/payments/get-patient-payments")
    public List<PaymentDTO> getPatientPayments(@RequestHeader Long id);
}
