package com.microservices.patient.repository;

import com.microservices.patient.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient , Long> {
}
