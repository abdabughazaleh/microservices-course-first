package com.microservices.doctor.service;

import com.microservices.doctor.model.dto.AddPatientDTO;
import com.microservices.doctor.model.dto.AddPaymentDTO;
import com.microservices.doctor.model.dto.PaymentDTO;
import com.microservices.doctor.proxy.PaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentProxy paymentProxy;

    public PaymentDTO addPayment(AddPaymentDTO dto){
        return this.paymentProxy.addPayment(dto);
    }


    public PaymentDTO getPayment(String tranId) {
        return this.paymentProxy.getPaymentByTranId(tranId);
    }
}
