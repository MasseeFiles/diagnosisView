//package com.medilabo.diagnosisview.configuration;
//
//import com.medilabo.diagnosisview.model.Patient;
//import com.medilabo.diagnosisview.repository.DiagnosisViewRepository;
//import com.medilabo.diagnosisview.repository.DiagnosisViewRepositoryJpa;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//
//@Configuration
//public class DataInit {
//
//    @Autowired
//    DiagnosisViewRepositoryJpa diagnosisViewRepositoryJpa;
//
//    @Bean
//    public DataInit init() {
//
//        Patient[] patients = new Patient[4];
//        patients[0] = new Patient(1L, "Test", "TestNone", LocalDate.of(1966, 12, 31), "F", "AA", "AA");
//        patients[1] = new Patient(2L, "Test", "TestBorderline", LocalDate.of(1945, 6, 24), "M", "BB", "BB");
//        patients[2] = new Patient(3L, "Test", "TestInDanger", LocalDate.of(2004, 6, 18), "M", "CC", "CC");
//        patients[3] = new Patient(4L, "Test", "TestEarlyOnset", LocalDate.of(2002, 6, 28), "F", "DD", "DD");
//
//        diagnosisViewRepositoryJpa.saveAll(Arrays.asList(patients));
//
//        return new DataInit();
//    }
//}
