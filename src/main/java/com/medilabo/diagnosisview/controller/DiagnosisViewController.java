package com.medilabo.diagnosisview.controller;

import com.medilabo.diagnosisview.service.DiagnosisViewService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DiagnosisViewController {
    private static final Logger logger = LogManager.getLogger("DiagnosisView_Controller");
    @Autowired
    private DiagnosisViewService diagnosisViewService;

    //point d'entree de l'appli - affichage des infos de tous les patients
    @GetMapping("/list")
    public ModelAndView showPatientList(ModelAndView modelAndView) {

        logger.info("Requete pour obtenir l'affichage de la liste de tous les patients");

        List<Object> patients = diagnosisViewService.getAllPatient();

        modelAndView.setViewName("/listPatient");
        modelAndView.addObject("patients", patients);
        return modelAndView;
    }

// Update d'un patient - affichage form
    @GetMapping("/{id}")
    public ModelAndView showPatientUpdateForm(@PathVariable("id") Long id, ModelAndView modelAndView) {

        logger.info("Requete pour l'affichage du formulaire d'update d'un patient");

        Object patientToShow = diagnosisViewService.getSinglePatient(id);
        modelAndView.setViewName("/updatePatient");
        modelAndView.addObject("patient", patientToShow);
        return modelAndView;
    }
//
//    // Update d'un patient - persistence en base
//    @PutMapping("/{id}")
//    public ModelAndView updateForm(@PathVariable("id") Long id, Object patientUpdated, ModelAndView modelAndView) {
//
//        logger.info("Requete pour la persistence en base d'un patient");
//
//        diagnosisViewService.updatePatient(id, patientUpdated);
//
//        modelAndView.setViewName("/listPatient");
//        return modelAndView;
//    }
}
