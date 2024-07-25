package com.medilabo.diagnosisview.service;

import com.medilabo.diagnosisview.model.PatientView;
import com.medilabo.diagnosisview.model.PatientViewDto;
import com.medilabo.diagnosisview.repository.RiskViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientViewMapper {

    @Autowired
    RiskViewRepository riskViewRepository;

    public PatientViewDto toDto(PatientView patientView) {
        if (patientView == null) {
            return null;
        }

        PatientViewDto patientViewDto = new PatientViewDto();
        patientViewDto.setPatientId(patientView.getPatientId());
        patientViewDto.setFirstName(patientView.getFirstName());
        patientViewDto.setLastName(patientView.getLastName());
        patientViewDto.setDateOfBirth(patientView.getDateOfBirth());
        patientViewDto.setGender(patientView.getGender());
        patientViewDto.setAddress(patientView.getAddress());
        patientViewDto.setPhoneNumber(patientView.getPhoneNumber());

        return patientViewDto;
    }

    public PatientView toEntity(PatientViewDto patientViewDto) {
        if (patientViewDto == null) {
            return null;
        }

        PatientView patientView = new PatientView();
        patientView.setPatientId(patientViewDto.getPatientId());
        patientView.setFirstName(patientViewDto.getFirstName());
        patientView.setLastName(patientViewDto.getLastName());
        patientView.setDateOfBirth(patientViewDto.getDateOfBirth());
        patientView.setGender(patientViewDto.getGender());
        patientView.setAddress(patientViewDto.getAddress());
        patientView.setPhoneNumber(patientViewDto.getPhoneNumber());
        patientView.setRiskLevel(riskViewRepository.getRiskLevel(patientViewDto.getPatientId()));

        return patientView;
    }

}

