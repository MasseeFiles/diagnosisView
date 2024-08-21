package com.medilabo.diagnosisview;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medilabo.diagnosisview.controller.NoteViewController;
import com.medilabo.diagnosisview.model.NoteView;
import com.medilabo.diagnosisview.service.NoteViewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(NoteViewController.class)
public class NoteViewControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteViewService noteViewService;

    @Test
    void showNoteList_shouldReturnModelAndViewUpdated() throws Exception {
        //GIVEN
        NoteView[] noteArray = new NoteView[1];
        noteArray[0] = new NoteView(1L, "Le patient déclare qu'il 'se sent très bien' Poids égal ou inférieur au poids recommandé");

        List<NoteView> noteListTest = new ArrayList<>((Arrays.asList(noteArray)));

        when(noteViewService.getNotes(1L)).thenReturn(noteListTest);

        //WHEN
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/noteView/{id}", 1L)
                )
                //THEN
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .view().name("/listNote"))
                .andExpect(MockMvcResultMatchers
                        .model().attributeExists("notes"));
    }

    @Test
    void showNoteForm_shouldReturnModelAndViewUpdated() throws Exception {
        //WHEN
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/noteView/noteForm/{id}", 1L)
                )
                //THEN
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .view().name("/noteForm"))
                .andExpect(MockMvcResultMatchers
                        .model().attributeExists("note"));
    }

    @Test
    void createNote_shouldReturnModelAndViewUpdated() throws Exception {
        //GIVEN
        NoteView noteToAddTest = new NoteView(1L, "note test");

        ObjectMapper mapper = new ObjectMapper();
        String jsonNote = mapper.writeValueAsString(noteToAddTest);

        //WHEN
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/noteView/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonNote))
                //THEN
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .view().name("/listNote"))
                .andExpect(MockMvcResultMatchers
                        .model().attributeExists("notes"));
    }

}