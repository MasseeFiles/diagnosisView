package com.medilabo.diagnosisview.repository;

import com.medilabo.diagnosisview.model.PatientView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Repository
@FeignClient(name = "DiagnosisApp", url = "http://localhost:8080")
public interface DiagnosisViewRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/patient")
    List<PatientView> findAllPatient();

    @RequestMapping(method = RequestMethod.GET, value = "/patient/{id}")
    PatientView findPatientById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.PUT, value = "/patient/{id}")
    void updatePatient(@PathVariable("id") Long id, PatientView patientToUpdate);
}
