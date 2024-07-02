package com.medilabo.diagnosisview.controller;

import com.medilabo.diagnosisview.service.DiagnosisViewService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DiagnosisViewController {
    private static final Logger logger = LogManager.getLogger("DiagnosisView_Controller");
    @Autowired
    private DiagnosisViewService diagnosisViewService;

    //point d'entree de l'appli
    @GetMapping("/list")
    public ModelAndView showPatientList(ModelAndView modelAndView) {

        logger.info("Requete pour obtenir l'affichage de la list<Patient> complète");

        List<Object> patients = diagnosisViewService.getAllPatient();

        modelAndView.setViewName("/list");
        modelAndView.addObject("patients", patients);
        return modelAndView;
    }
}
