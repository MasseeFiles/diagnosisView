package com.medilabo.diagnosisview.service;

import com.medilabo.diagnosisview.model.PatientView;
import com.medilabo.diagnosisview.repository.DiagnosisViewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisViewService {
    private final DiagnosisViewRepository diagnosisViewRepository;

    public DiagnosisViewService(DiagnosisViewRepository diagnosisViewRepository) {
        this.diagnosisViewRepository = diagnosisViewRepository;
    }

    public List<PatientView> getAllPatient() {
        return diagnosisViewRepository.findAllPatient();
    }

    public PatientView getSinglePatient(Long id) {
        return diagnosisViewRepository.findPatientById(id);
    }

    public void updatePatient(Long id, PatientView patientToUpdate) {
        diagnosisViewRepository.updatePatient(id, patientToUpdate);
    }
}
