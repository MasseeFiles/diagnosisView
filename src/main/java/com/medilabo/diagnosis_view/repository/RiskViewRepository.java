package com.medilabo.diagnosis_view.repository;

import com.medilabo.diagnosis_view.configuration.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
@FeignClient(name = "toRiskServiceViaGateway", url = "#{toGatewayServiceUrl}", configuration = FeignClientConfig.class)
//@FeignClient(name = "toRiskService", url = "http://localhost:8085", configuration = FeignClientConfig.class)
public interface RiskViewRepository {
    @RequestMapping(method = RequestMethod.GET, value = "/risks/{id}")
    String getRiskLevel(@PathVariable("id") Long id);

}


