package com.microservices.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorApplication.class, args);
	}

}
