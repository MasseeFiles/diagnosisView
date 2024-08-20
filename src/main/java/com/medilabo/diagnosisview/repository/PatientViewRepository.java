package com.medilabo.diagnosisview.repository;

import com.medilabo.diagnosisview.model.PatientViewDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Repository
//@FeignClient(name = "toPatientViaGateway", url = "http://localhost:8084")
@FeignClient(name = "diagnosisPatient", url = "http://localhost:8081")
public interface PatientViewRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/patient")
    List<PatientViewDto> findAllPatient();

    @RequestMapping(method = RequestMethod.GET, value = "/patient/{id}")
    PatientViewDto findPatientById(@PathVariable("id") Long id);

//    @RequestMapping(method = RequestMethod.POST, value = "/updateForm/{id}")
//    PatientViewDto findPatientById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.PUT, value = "/patient/{id}")
    void updatePatient(@PathVariable("id") Long id, PatientViewDto patientToUpdate);

}
