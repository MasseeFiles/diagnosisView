package com.medilabo.diagnosis_view.service;

import com.medilabo.diagnosis_view.model.PatientView;
import com.medilabo.diagnosis_view.model.PatientViewDto;
import com.medilabo.diagnosis_view.repository.PatientViewRepository;
import com.medilabo.diagnosis_view.repository.RiskViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientViewService {
    private final PatientViewRepository patientViewRepository;
    private final RiskViewRepository riskViewRepository;

    @Autowired
    private PatientViewMapper patientViewMapper;

    public PatientViewService(PatientViewRepository patientViewRepository, RiskViewRepository riskViewRepository) {
        this.patientViewRepository = patientViewRepository;
        this.riskViewRepository = riskViewRepository;
    }

    public List<PatientView> getAllPatient() {
        return patientViewRepository.findAllPatient().stream()
                .map(patientViewMapper::toEntity)
                .collect(Collectors.toList());
    }

    public PatientView getSinglePatient(Long id) {
        PatientViewDto patientViewDto = patientViewRepository.findPatientById(id);
        return patientViewMapper.toEntity(patientViewDto);
    }

    public void updatePatient(Long id, PatientView patientToUpdate) {
        PatientViewDto patientViewDto = patientViewMapper.toDto(patientToUpdate);
        patientViewRepository.updatePatient(id, patientViewDto);
    }

}
