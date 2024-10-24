package com.medilabo.diagnosis_view.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class FeignClientConfig {

    @Value("${NOTE_IP}")
    private String noteIp;

    @Value("${NOTE_PORT}")
    private int notePort;

    @Bean
    public String toNoteServiceUrl() {
        String uriNote = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(noteIp)
                .port(notePort)
                .build()
                .toUriString();

        return uriNote;
    }

    @Value("${RISK_IP}")
    private String riskIp;

    @Value("${RISK_PORT}")
    private int riskPort;

    @Bean
    public String toRiskServiceUrl() {
        String uriRisk = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(riskIp)
                .port(riskPort)
                .build()
                .toUriString();

        return uriRisk;
    }

    @Value("${PATIENT_IP}")
    private String patientIp;

    @Value("${PATIENT_PORT}")
    private int patientPort;

    @Bean
    public String toPatientServiceUrl() {
        String uriPatient = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(patientIp)
                .port(patientPort)
                .build()
                .toUriString();

        return uriPatient;
    }

    @Bean
    public ForwardedAuthHeaderInterceptor forwardedAuthHeaderInterceptor() {
        return new ForwardedAuthHeaderInterceptor();
    }

}