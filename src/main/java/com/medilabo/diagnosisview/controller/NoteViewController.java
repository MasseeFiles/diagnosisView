package com.medilabo.diagnosisview.controller;

import com.medilabo.diagnosisview.model.NoteView;
import com.medilabo.diagnosisview.service.NoteViewService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/noteView")
public class NoteViewController {
    private static final Logger logger = LogManager.getLogger("NoteViewController");

    @Autowired
    private NoteViewService noteViewService;

    @GetMapping("/{id}")   //id correspond à id du patient visé et se transforme dans le service en customId
    public ModelAndView showNoteList(@PathVariable("id") Long patientId, ModelAndView modelAndView) {

        logger.info("Requete pour obtenir l'affichage de la liste des notes pour un patient");

        List<NoteView> notes = noteViewService.getNotes(patientId);

        modelAndView.setViewName("/listNote");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }

    @PostMapping("/noteForm/{id}")
    public ModelAndView showNoteForm(@PathVariable("id") Long id, ModelAndView modelAndView) {

        logger.info("Requete pour l'affichage du formulaire de creation d'une note");

        NoteView noteview = new NoteView();
        noteview.setCustomId(id);

        modelAndView.setViewName("/noteForm");
        modelAndView.addObject("note", noteview);
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView createNote(NoteView noteToAdd, ModelAndView modelAndView) {

        logger.info("Requete pour la persistence en base d'une note");

        noteViewService.addNote(noteToAdd);

        List<NoteView> notes = noteViewService.getNotes(noteToAdd.getCustomId());
        modelAndView.setViewName("/listNote");
        modelAndView.addObject("notes", notes);

        return modelAndView;
    }

}
