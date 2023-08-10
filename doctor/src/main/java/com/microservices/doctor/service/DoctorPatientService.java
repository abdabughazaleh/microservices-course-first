package com.microservices.doctor.service;

import com.microservices.doctor.model.dto.AddPatientDTO;
import com.microservices.doctor.model.dto.PatientDTO;
import com.microservices.doctor.proxy.PatientProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DoctorPatientService {

    @Autowired
    private PatientProxy patientProxy;


    public PatientDTO getPatient(Long id) {
        log.info("getting patient details for patient id : {} ", id);
        PatientDTO patientDTO = this.patientProxy.get(id);
        log.info("patient details {} ", patientDTO);
        return patientDTO;
    }


    public AddPatientDTO addPatient(AddPatientDTO dto) {
        log.info("start getting patient info {} ", dto);
        AddPatientDTO save = this.patientProxy.save(dto);
        log.info("successfully saved patient details {} ", save);
        return save;
    }
}
