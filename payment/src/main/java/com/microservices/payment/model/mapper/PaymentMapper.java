package com.microservices.payment.model.mapper;

import com.microservices.payment.model.dto.PaymentDTO;
import com.microservices.payment.model.entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDTO toDTO(Payment entity);
    Payment toEntity(PaymentDTO dto);
    List<PaymentDTO> toDTOs(List<Payment> entities);
    List<Payment> toEntities(List<PaymentDTO> dtos);
}
