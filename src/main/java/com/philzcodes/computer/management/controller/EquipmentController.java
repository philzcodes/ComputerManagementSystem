package com.philzcodes.computer.management.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.philzcodes.computer.management.model.Equipment;
import com.philzcodes.computer.management.service.EquipmentService;

@Controller
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/equipment")
    public String viewAllEquipment(Model model) {
        model.addAttribute("equipmentList", equipmentService.findAll());
        return "equipment";  // Refers to the Thymeleaf template "equipment.html"
    }

    @PostMapping("/equipment/add")
    public String addEquipment(@ModelAttribute Equipment equipment) {
        equipmentService.save(equipment);
        return "redirect:/equipment";  // Redirect back to the equipment list
    }

    @GetMapping("/equipment/edit/{id}")
    @ResponseBody  // Return the Equipment object as JSON for editing
    public Equipment editEquipment(@PathVariable Long id) {
        return equipmentService.findById(id);  // Return the equipment by ID for editing
    }

    @PostMapping("/equipment/edit/{id}")
    public String updateEquipment(@PathVariable Long id, @ModelAttribute Equipment equipment) {
        equipment.setId(id);  // Ensure the correct ID is set
        equipmentService.save(equipment);  // Save the updated equipment
        return "redirect:/equipment";
    }

    @DeleteMapping("/equipment/delete/{id}")
    @ResponseBody
    public String deleteEquipment(@PathVariable Long id) {
        equipmentService.delete(id);  // Delete the equipment
        return "Equipment deleted successfully!";
    }
    

//    @GetMapping("/details/{id}")
//    public String equipmentDetails(@PathVariable Long id, Model model) {
//        Optional<Equipment> equipmentOpt = equipmentService.getEquipmentById(id);
//        if (equipmentOpt.isPresent()) {
//            Equipment equipment = equipmentOpt.get();
//            model.addAttribute("equipment", equipment);
//
//            // Convert the failureProbability string to an array for Chart.js
//            String[] failureProbabilityArray = equipment.getFailureProbability().split(",");
//            model.addAttribute("failureProbabilities", failureProbabilityArray);
//
//            return "equipment-details";
//        }
//        return "redirect:/equipment";
//    }
    
    @GetMapping("/equipment/details/{id}")
    public String equipmentDetails(@PathVariable Long id, Model model) {
        Optional<Equipment> equipmentOpt = equipmentService.getEquipmentById(id);
        if (equipmentOpt.isPresent()) {
            Equipment equipment = equipmentOpt.get();
            model.addAttribute("equipment", equipment);
//            model.addAttribute("failureProbabilities", new double[]{10, 20, 15, 25, 35, 50, 65});  // Sample data
//            model.addAttribute("riskLevels", new int[]{3, 2, 5, 4, 1}); // Sample data
            return "equipment-details";
        }
        return "redirect:/equipment";
    }
    
    @GetMapping("/equipment/details/risk/{id}")
    @ResponseBody
    public int[] equipmentDetailsRiskLevels(@PathVariable Long id) {
       
        return new int[]{3, 2, 5, 4, 1};
    }
    
    @GetMapping("/equipment/details/failure/{id}")
    @ResponseBody
    public double[] equipmentDetailsFailureProbabilities(@PathVariable Long id) {
       
        return new double[]{10, 20, 15, 25, 35, 50, 65};
    }
    
    
    

}
