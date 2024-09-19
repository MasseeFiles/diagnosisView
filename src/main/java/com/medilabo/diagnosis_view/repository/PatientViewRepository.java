package com.medilabo.diagnosis_view.repository;

import com.medilabo.diagnosis_view.configuration.FeignClientConfig;
import com.medilabo.diagnosis_view.model.PatientViewDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Repository
@FeignClient(name = "toPatientServiceViaGateway", url = "#{toGatewayServiceUrl}", configuration = FeignClientConfig.class)
//@FeignClient(name = "toPatientService", url = "http://localhost:8081", configuration = FeignClientConfig.class)
public interface PatientViewRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/patients")
    List<PatientViewDto> findAllPatient();

    @RequestMapping(method = RequestMethod.GET, value = "/patients/{id}")
    PatientViewDto findPatientById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.PUT, value = "/patients/{id}")
    void updatePatient(@PathVariable("id") Long id, PatientViewDto patientToUpdate);

}
