package com.microservices.doctor.proxy;

import com.microservices.doctor.model.dto.AddPaymentDTO;
import com.microservices.doctor.model.dto.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PAYMENT-SERVICE" , path = "/payment")
public interface PaymentProxy {
    @GetMapping("/payments/payment-by-tran")
    public PaymentDTO getPaymentByTranId(@RequestParam String tranId);
    @PostMapping("/payments/add-payment")
    public PaymentDTO addPayment(@RequestBody AddPaymentDTO dto);
}
