package com.medilabo.diagnosisview;


import com.medilabo.diagnosisview.model.PatientView;
import com.medilabo.diagnosisview.service.DiagnosisViewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@WebMvcTest
public class DiagnosisViewControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DiagnosisViewService diagnosisViewService;

    @Test
    void showPatientList_shouldReturnModelAndViewUpdated() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/list")
                )
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .view().name("/listPatient"))
                .andExpect(MockMvcResultMatchers
                        .model().attributeExists("patients"));
    }

    @Test
    void showPatientUpdateForm_shouldReturnModelAndViewUpdated() throws Exception {
        PatientView patientTest = new PatientView(1L, "Test", "TestNone", LocalDate.of(1966, 12, 31), "F", "AA", "AA");
        when(diagnosisViewService.getSinglePatient(1L)).thenReturn(patientTest);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/updateForm/{id}", 1L)
                )
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .view().name("/updatePatient"))
                .andExpect(MockMvcResultMatchers
                        .model().attributeExists("patient"));
    }

    @Test
    void updatePatient_shouldReturnModelAndViewUpdated() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/{id}", 1L)
                )
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .model().attributeExists("patients"))
                .andExpect(MockMvcResultMatchers
                        .view().name("/listPatient"));
    }
}
