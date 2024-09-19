package com.medilabo.diagnosis_view;

import com.medilabo.diagnosis_view.model.PatientView;
import com.medilabo.diagnosis_view.model.PatientViewDto;
import com.medilabo.diagnosis_view.repository.RiskViewRepository;
import com.medilabo.diagnosis_view.service.PatientViewMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PatientViewMapperTests {

    @Mock
    private RiskViewRepository riskViewRepository;

    @InjectMocks
    private PatientViewMapper mapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void toDto_shouldReturnPatientViewDto() {
        //GIVEN
        PatientView patientView = new PatientView();
        patientView.setPatientId(1L);
        patientView.setFirstName("John");
        patientView.setLastName("Smith");
        patientView.setDateOfBirth(LocalDate.of(2024, 1, 1));
        patientView.setGender("M");
        patientView.setAddress("AA");
        patientView.setPhoneNumber("123-456");

        //WHEN
        PatientViewDto patientViewDto = mapper.toDto(patientView);

        //THEN
        assertEquals(patientView.getPatientId(), patientViewDto.getPatientId());
        assertEquals(patientView.getFirstName(), patientViewDto.getFirstName());
        assertEquals(patientView.getLastName(), patientViewDto.getLastName());
        assertEquals(patientView.getDateOfBirth(), patientViewDto.getDateOfBirth());
        assertEquals(patientView.getGender(), patientViewDto.getGender());
        assertEquals(patientView.getAddress(), patientViewDto.getAddress());
        assertEquals(patientView.getPhoneNumber(), patientViewDto.getPhoneNumber());
    }

    @Test
    public void toDto_shouldReturnNull() {
        //WHEN
        PatientViewDto patientViewDto = mapper.toDto(null);

        //THEN
        assertNull(patientViewDto);
    }

    @Test
    public void toEntity_shouldReturnEntity() {
        //GIVEN
        PatientViewDto patientViewDto = new PatientViewDto();
        patientViewDto.setPatientId(1L);
        patientViewDto.setFirstName("John");
        patientViewDto.setLastName("Smith");
        patientViewDto.setDateOfBirth(LocalDate.of(2024, 1, 1));
        patientViewDto.setGender("M");
        patientViewDto.setAddress("AA");
        patientViewDto.setPhoneNumber("123-456");

        String expectedRiskLevel = "No Risk";
        when(riskViewRepository.getRiskLevel(patientViewDto.getPatientId())).thenReturn(expectedRiskLevel);

        //WHEN
        PatientView patientView = mapper.toEntity(patientViewDto);

        //THEN
        assertEquals(patientViewDto.getPatientId(), patientView.getPatientId());
        assertEquals(patientViewDto.getFirstName(), patientView.getFirstName());
        assertEquals(patientViewDto.getLastName(), patientView.getLastName());
        assertEquals(patientViewDto.getDateOfBirth(), patientView.getDateOfBirth());
        assertEquals(patientViewDto.getGender(), patientView.getGender());
        assertEquals(patientViewDto.getAddress(), patientView.getAddress());
        assertEquals(patientViewDto.getPhoneNumber(), patientView.getPhoneNumber());
        assertEquals(expectedRiskLevel, patientView.getRiskLevel());

        verify(riskViewRepository).getRiskLevel(patientViewDto.getPatientId());
    }

    @Test
    public void toEntity_shouldReturnNull() {
        //WHEN
        PatientView patientView = mapper.toEntity(null);

        //THEN
        assertNull(patientView);
    }

}
