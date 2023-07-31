package com.microservices.doctor.service;

import com.microservices.doctor.proxy.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DoctorPatientService {

    @Autowired
    private PatientProxy patientProxy;

    public String getPatient(String name){
        String fullUrl = "http://localhost:9000/search/" + name;
        RestTemplate restTemplate = new RestTemplate();
        String patientName = restTemplate
                .getForObject(fullUrl, String.class);
        return patientName;
    }

    public String getPatientByFeignClient(String name){
        return this.patientProxy.getName(name);
    }

}
