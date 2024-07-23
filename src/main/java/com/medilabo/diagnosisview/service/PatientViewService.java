package com.medilabo.diagnosisview.service;

import com.medilabo.diagnosisview.model.PatientView;
import com.medilabo.diagnosisview.repository.PatientViewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientViewService {
    private final PatientViewRepository patientViewRepository;

    public PatientViewService(PatientViewRepository patientViewRepository) {
        this.patientViewRepository = patientViewRepository;
    }

    public List<PatientView> getAllPatient() {
        return patientViewRepository.findAllPatient();
    }

    public PatientView getSinglePatient(Long id) {
        return patientViewRepository.findPatientById(id);
    }

    public void updatePatient(Long id, PatientView patientToUpdate) {
        patientViewRepository.updatePatient(id, patientToUpdate);
    }
}
