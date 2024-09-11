package com.philzcodes.computer.management.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philzcodes.computer.management.model.Equipment;
import com.philzcodes.computer.management.model.MaintenanceSchedule;
import com.philzcodes.computer.management.model.MaintenanceScheduleEvent;
import com.philzcodes.computer.management.model.User;
import com.philzcodes.computer.management.respository.MaintenanceScheduleRepository;

@Service
public class MaintenanceScheduleService {

    @Autowired
    private MaintenanceScheduleRepository repository;

    // Get all scheduled tasks as events
    public List<MaintenanceScheduleEvent> getAllEvents() {
        List<MaintenanceSchedule> schedules = repository.findAll();
        List<MaintenanceScheduleEvent> events = new ArrayList<>();

        for (MaintenanceSchedule schedule : schedules) {
            MaintenanceScheduleEvent event = new MaintenanceScheduleEvent();
            event.setTitle(schedule.getTaskName());
            event.setStart(schedule.getDate().toString());
            event.setEnd(schedule.getDate().toString());
            event.setDescription("Maintenance for " + schedule.getEquipment());
            event.setEquipment(schedule.getEquipment());
            event.setAssignedTo(schedule.getTechnician());
            events.add(event);
        }
        return events;
    }
    
    // This method will fetch upcoming maintenance schedules
 // This method will fetch upcoming maintenance schedules
    public List<MaintenanceSchedule> getUpcomingSchedules() {
        List<MaintenanceSchedule> schedules = repository.findAll();

        // Create DTOs to return only necessary data
        List<MaintenanceSchedule> upcomingSchedules = new ArrayList<>();
        
        LocalDate today = LocalDate.now();
        
        for (MaintenanceSchedule schedule : schedules) {
            // Check if scheduled date is not null
            if (schedule.getDate() != null && schedule.getDate().isAfter(today)) {
            	MaintenanceSchedule dto = new MaintenanceSchedule();
                dto.setEquipment(schedule.getEquipment());
                dto.setDate(schedule.getDate());
                upcomingSchedules.add(dto);
            }
        }

        return upcomingSchedules;
    }

    public MaintenanceSchedule save(MaintenanceSchedule task) {
        return repository.save(task);
    }

    // Get all equipment and technicians (mocked here, but should fetch from DB)
    public List<Equipment> getAllEquipment() {
        // Mocked list of equipment
        return Arrays.asList(new Equipment("Server 1"), new Equipment("Router 2"), new Equipment("Switch 3"));
    }

    public List<User> getAllTechnicians() {
        // Mocked list of technicians
        return Arrays.asList(new User("Technician A"), new User("Technician B"), new User("Technician C"));
    }
}

