package com.medilabo.diagnosisview.service;

import com.medilabo.diagnosisview.model.NoteView;
import com.medilabo.diagnosisview.repository.NoteViewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteViewService {
    private final NoteViewRepository noteViewRepository;

    public NoteViewService(NoteViewRepository noteViewRepository) {
        this.noteViewRepository = noteViewRepository;
    }

    public List<NoteView> getNotes(Long id) {
        return noteViewRepository.findNoteByCustomId(id);
    }

    public void addNote(NoteView noteToAdd) {
        Long id = noteToAdd.getCustomId();
        String noteField = noteToAdd.getNoteField();
        noteViewRepository.createNote(id, noteField);
    }
}
