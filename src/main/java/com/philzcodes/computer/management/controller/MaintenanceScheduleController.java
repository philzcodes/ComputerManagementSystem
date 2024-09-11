package com.philzcodes.computer.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.philzcodes.computer.management.model.MaintenanceSchedule;
import com.philzcodes.computer.management.model.MaintenanceScheduleEvent;
import com.philzcodes.computer.management.service.MaintenanceScheduleService;

@Controller
public class MaintenanceScheduleController {

    @Autowired
    private MaintenanceScheduleService maintenanceScheduleService;

    @GetMapping("/maintenance")
    public String viewSchedule(Model model) {
        // Add equipment and technicians lists to the model for the dropdowns
        model.addAttribute("equipmentList", maintenanceScheduleService.getAllEquipment());
        model.addAttribute("technicianList", maintenanceScheduleService.getAllTechnicians());
        return "maintenance_schedule"; // Thymeleaf template name
    }

    @GetMapping("/maintenance/events")
    @ResponseBody
    public List<MaintenanceScheduleEvent> getEvents() {
        return maintenanceScheduleService.getAllEvents(); // Fetch events from service
    }

    @PostMapping("/maintenance/add")
    @ResponseBody
    public MaintenanceSchedule addTask(@ModelAttribute MaintenanceSchedule task) {
        return maintenanceScheduleService.save(task); // Save the task and return it
    }
}
