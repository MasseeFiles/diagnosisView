package com.medilabo.diagnosisview.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Repository
@FeignClient(name = "Diagnosis", url = "http://localhost:8080/patient")
public interface DiagnosisViewRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/patient")
    public ResponseEntity<List<Object>> findAllPatients();
}
