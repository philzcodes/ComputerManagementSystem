package com.philzcodes.computer.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.philzcodes.computer.management.model.MaintenancePrediction;
import com.philzcodes.computer.management.service.MaintenancePredictionService;

@Controller
public class DSSController {

    @Autowired
    private MaintenancePredictionService predictionService;

    @GetMapping("/dss")
    public String viewPredictions(Model model) {
        model.addAttribute("predictions", predictionService.findAll());
        return "dss-predictions";
    }

    @PostMapping("/dss/add")
    public String addPrediction(@ModelAttribute MaintenancePrediction prediction) {
        predictionService.save(prediction);
        return "redirect:/dss";
    }

    @GetMapping("/dss/delete/{id}")
    public String deletePrediction(@PathVariable Long id) {
        predictionService.delete(id);
        return "redirect:/dss";
    }
}
