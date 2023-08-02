package com.microservices.payment.model.repository;

import com.microservices.payment.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepo extends JpaRepository<Payment , Long> {
    Optional<Payment> findByTranId(String tranId);
}
