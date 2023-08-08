package com.microservices.patient.model.mapper;

import com.microservices.patient.model.dto.PatientDTO;
import com.microservices.patient.model.dto.UpdatePatientDTO;
import com.microservices.patient.model.entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toEntity(PatientDTO dto);
    PatientDTO toDTO(Patient entity);
    Patient toUpdateEntity(UpdatePatientDTO dto);
}
