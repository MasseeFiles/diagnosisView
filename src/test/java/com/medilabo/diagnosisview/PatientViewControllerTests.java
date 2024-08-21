package com.medilabo.diagnosisview;

import com.medilabo.diagnosisview.controller.PatientViewController;
import com.medilabo.diagnosisview.model.PatientView;
import com.medilabo.diagnosisview.service.PatientViewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(PatientViewController.class)
public class PatientViewControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientViewService patientViewService;

    @Test
    void showPatientList_shouldReturnModelAndViewUpdated() throws Exception {
        //GIVEN
        PatientView[] patientArray = new PatientView[2];
        patientArray[0] = new PatientView(1L, "Test", "TestNone", LocalDate.of(1966, 12, 31), "F", "AA", "AA", "Borderline");
        patientArray[1] = new PatientView(2L, "Test", "TestBorderline", LocalDate.of(1945, 6, 24), "M", "BB", "BB", "In danger");

        List<PatientView> patientListTest = new ArrayList<>((Arrays.asList(patientArray)));

        when(patientViewService.getAllPatient()).thenReturn(patientListTest);
        //WHEN
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/list")
                )
                //THEN
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .view().name("/listPatient"))
                .andExpect(MockMvcResultMatchers
                        .model().attributeExists("patients"));
    }

    @Test
    void showPatientUpdateForm_shouldReturnModelAndViewUpdated() throws Exception {
        //GIVEN
        PatientView patientTest = new PatientView(1L, "Test", "TestNone", LocalDate.of(1966, 12, 31), "F", "AA", "AA", "Borderline");
        when(patientViewService.getSinglePatient(1L)).thenReturn(patientTest);

        //WHEN
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/updateForm/{id}", 1L)
                )
                //THEN
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .view().name("/updatePatientForm"))
                .andExpect(MockMvcResultMatchers
                        .model().attributeExists("patient"));
    }

    @Test
    void updatePatient_shouldReturnModelAndViewUpdated() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/patient/{id}", 1L)
                )
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .model().attributeExists("patients"))
                .andExpect(MockMvcResultMatchers
                        .view().name("/listPatient"));
    }

}


