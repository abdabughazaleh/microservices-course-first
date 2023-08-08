package com.microservices.payment.repository;

import com.microservices.payment.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepo extends JpaRepository<Payment , Long> {
    Optional<Payment> findByTranId(String tranId);
    List<Payment> findAllByPatientId(Long patientId);
}
