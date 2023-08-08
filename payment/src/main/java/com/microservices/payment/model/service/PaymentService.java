package com.microservices.payment.model.service;

import com.microservices.payment.model.dto.AddPaymentDTO;
import com.microservices.payment.model.dto.PaymentDTO;
import com.microservices.payment.model.entity.Payment;
import com.microservices.payment.model.mapper.PaymentMapper;
import com.microservices.payment.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private PaymentMapper paymentMapper;

    public PaymentDTO getPayment(String tranId){
        Optional<Payment> payment = this.paymentRepo.findByTranId(tranId);
        return paymentMapper.toDTO(payment.get());
    }

    public PaymentDTO addPayment(AddPaymentDTO dto) {

        String tranId = UUID.randomUUID().toString();
        PaymentDTO paymentDTO = PaymentDTO.builder()
                .amount(dto.getAmount())
                .patientId(dto.getPatientId())
                .tranId(tranId)
                .build();
        Payment entity = this.paymentMapper.toEntity(paymentDTO);
        Payment savedPayment = this.paymentRepo.save(entity);
        return this.paymentMapper.toDTO(savedPayment);
    }


    public List<PaymentDTO> getPatientPayments(Long patientId){
        List<Payment> payments = this.paymentRepo.findAllByPatientId(patientId);
        return this.paymentMapper.toDTOs(payments);
    }
}
