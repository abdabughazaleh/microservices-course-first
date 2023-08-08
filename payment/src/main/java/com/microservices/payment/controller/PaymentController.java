package com.microservices.payment.controller;

import com.microservices.payment.model.dto.AddPaymentDTO;
import com.microservices.payment.model.dto.PaymentDTO;
import com.microservices.payment.model.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
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
    @GetMapping("/get-patient-payments")
    public List<PaymentDTO> getPatientPayments(@RequestHeader Long id){
        return this.paymentService.getPatientPayments(id);
    }
}
