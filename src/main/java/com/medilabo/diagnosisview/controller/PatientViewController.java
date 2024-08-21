package com.medilabo.diagnosisview.controller;

import com.medilabo.diagnosisview.model.PatientView;
import com.medilabo.diagnosisview.service.PatientViewService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PatientViewController {
    private static final Logger logger = LogManager.getLogger("PatientViewController");
    @Autowired
    private PatientViewService patientViewService;

    //point d'entree de l'appli - affichage des infos de tous les patients
    @GetMapping("/list")
    public ModelAndView showPatientList(ModelAndView modelAndView) {

        logger.info("Requete pour obtenir l'affichage de la liste de tous les patients");

        List<PatientView> patients = patientViewService.getAllPatient();

        modelAndView.setViewName("/listPatient");
        modelAndView.addObject("patients", patients);
        return modelAndView;
    }

    //     Update d'un patient - affichage form
    @GetMapping("/updateForm/{id}")
    public ModelAndView showPatientUpdateForm(@PathVariable("id") Long id, ModelAndView modelAndView) {

        logger.info("Requete pour l'affichage du formulaire d'update d'un patient");

        PatientView patientToShow = patientViewService.getSinglePatient(id);
        modelAndView.setViewName("/updatePatientForm");
        modelAndView.addObject("patient", patientToShow);
        return modelAndView;
    }

    // Update d'un patient - persistence en base
    @PostMapping("/patient/{id}")
    public ModelAndView updatePatient(@PathVariable("id") Long id, PatientView patientUpdated, ModelAndView modelAndView) {

        logger.info("Requete pour la persistence en base d'un patient");

        patientViewService.updatePatient(id, patientUpdated);

        List<PatientView> patients = patientViewService.getAllPatient();
        modelAndView.setViewName("/listPatient");
        modelAndView.addObject("patients", patients);
        return modelAndView;
    }

}

