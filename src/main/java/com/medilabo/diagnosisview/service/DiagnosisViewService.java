package com.medilabo.diagnosisview.service;

import com.medilabo.diagnosisview.repository.DiagnosisViewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisViewService {
    private final DiagnosisViewRepository diagnosisViewRepository;

    public DiagnosisViewService(DiagnosisViewRepository diagnosisViewRepository) {
        this.diagnosisViewRepository = diagnosisViewRepository;
    }

    public List<Object> getAllPatient() {
        return diagnosisViewRepository.findAllPatient();
    }

    public Object getSinglePatient(Long id) {
        return diagnosisViewRepository.findPatientById(id);
    }

    public void updatePatient(Long id, Object patientToUpdate) {
        diagnosisViewRepository.updatePatient(id, patientToUpdate);
    }
}
