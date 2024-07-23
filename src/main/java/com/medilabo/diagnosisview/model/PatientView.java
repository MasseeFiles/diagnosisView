package com.medilabo.diagnosisview.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientView {
    private Long patientId;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String genre;

    private String address;

    private String phoneNumber;
}
