package com.microservices.patient.service;

import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.model.dto.PatientDTO;
import com.microservices.patient.model.dto.UpdatePatientDTO;
import com.microservices.patient.model.entity.Patient;
import com.microservices.patient.model.mapper.PatientMapper;
import com.microservices.patient.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private PatientRepo patientRepo;
    private List<String> names = Arrays.asList("Ahmad", "Abd", "Khaled");

    public String getName(String name){
        return names.stream().filter(n -> n.equals(name))
                .findAny().orElse("No patient found!");
    }

    public AddPatientDTO save(AddPatientDTO dto){
        Patient entity = Patient.builder()
                .patientName(dto.getPatientName())
                .patientAge(dto.getPatientAge())
                .build();

        Patient patient = this.patientRepo.save(entity);

        return  AddPatientDTO.builder()
                .patientAge(patient.getPatientAge())
                .patientName(patient.getPatientName())
                .build();
    }

    public PatientDTO update(UpdatePatientDTO dto){
        Patient updateEntity = this.patientMapper.toUpdateEntity(dto);
        Patient patient = this.patientRepo.save(updateEntity);
        return  this.patientMapper.toDTO(patient);
    }

    public void delete(Long id) {
        this.patientRepo.deleteById(id);
    }

    public PatientDTO get(Long id) {
        Optional<Patient> patient = this.patientRepo.findById(id);
        return this.patientMapper.toDTO(patient.get());
    }
}
