package com.example.myapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.myapp.domain.PatientForm;
import com.example.myapp.services.DiabetesPredictionService;

import jakarta.validation.Valid;

@Controller
public class DiabetesPredictionController {

    @Autowired
    private DiabetesPredictionService predictionService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("patientForm",
                new PatientForm(3,100,100,50,80,60,0F,40));
        return "formView";
    }

    @PostMapping("/prediction")
    public String calculatePrediction(@Valid PatientForm pacientForm,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors())
            return "redirect:/";

        String prediction = predictionService.calculatePrediction(pacientForm);
        model.addAttribute("prediction", prediction);
        return "resultView";
    }
 }
