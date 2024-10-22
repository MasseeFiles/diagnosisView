package com.medilabo.diagnosis_view.service;

import com.medilabo.diagnosis_view.model.PatientView;
import com.medilabo.diagnosis_view.model.PatientViewDto;
import com.medilabo.diagnosis_view.repository.RiskViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mapper utilisé pour convertir les objets PatientViewDto (reçus du microservice Patient)
 * en objets PatientView (ajout du niveau de risque reçu du microservice Risk).
 * @see PatientView
 * @see PatientViewDto
 * @see PatientViewService
 */
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

