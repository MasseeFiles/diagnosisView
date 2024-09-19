package com.medilabo.diagnosis_view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DiagnosisViewApplication {
	public static void main(String[] args) {
		SpringApplication.run(DiagnosisViewApplication.class, args);
	}

}
