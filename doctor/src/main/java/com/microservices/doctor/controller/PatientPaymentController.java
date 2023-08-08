package com.microservices.doctor.controller;

import com.microservices.doctor.model.dto.AddPaymentDTO;
import com.microservices.doctor.model.dto.PaymentDTO;
import com.microservices.doctor.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PatientPaymentController {
    @Autowired
    private PaymentService paymentService;
    @GetMapping("/payment-by-tran")
    public PaymentDTO getPaymentByTranId(@RequestParam String tranId){
        return this.paymentService.getPayment(tranId);
    }
    @PostMapping("/add-payment")
    public PaymentDTO addPayment(@RequestBody AddPaymentDTO dto){
        return this.paymentService.addPayment(dto);
    }
}
