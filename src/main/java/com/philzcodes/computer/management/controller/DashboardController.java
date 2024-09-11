package com.philzcodes.computer.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.philzcodes.computer.management.model.Equipment;
import com.philzcodes.computer.management.model.MaintenanceSchedule;
import com.philzcodes.computer.management.service.EquipmentService;
import com.philzcodes.computer.management.service.MaintenanceScheduleService;

@Controller
public class DashboardController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private MaintenanceScheduleService maintenanceScheduleService;

//    @Autowired
//    private AlertService alertService;
//
//    @Autowired
//    private NotificationService notificationService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Sample data fetching, replace these with actual services or database calls
        String systemStatus = "All systems are operational.";
        
        List<Equipment> equipmentHealth = equipmentService.getEquipmentHealth();  // A method that returns the health status
        List<MaintenanceSchedule> upcomingMaintenance = maintenanceScheduleService.getUpcomingSchedules();  // Method returning upcoming schedules
//        List<Alert> recentAlerts = alertService.getRecentAlerts();  // Method returning recent alerts
//        List<Notification> systemNotifications = notificationService.getRecentNotifications();  // Method returning recent system notifications

        // Add attributes to the model that Thymeleaf will use
        model.addAttribute("systemStatus", systemStatus);
        model.addAttribute("equipmentHealth", equipmentHealth);
        model.addAttribute("upcomingMaintenance", upcomingMaintenance);
//        model.addAttribute("recentAlerts", recentAlerts);
//        model.addAttribute("systemNotifications", systemNotifications);

        return "dashboard";  // This refers to the Thymeleaf template "dashboard.html"
    }
}
