package com.microservices.patient.service;

import com.microservices.patient.model.dto.PaymentDTO;
import com.microservices.patient.proxy.PaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientPaymentService {
    @Autowired
    private PaymentProxy paymentProxy;

    public List<PaymentDTO> getPatientPayments(Long patientId){
        return this.paymentProxy.getPatientPayments(patientId);
    }
}
