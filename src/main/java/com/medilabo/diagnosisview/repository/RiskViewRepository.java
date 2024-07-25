package com.medilabo.diagnosisview.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
@FeignClient(name = "diagnosisRisk", url = "http://localhost:8085")
public interface RiskViewRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/risk/{id}")
    String getRiskLevel(@PathVariable("id") Long id);

}


