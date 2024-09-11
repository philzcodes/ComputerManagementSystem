package com.philzcodes.computer.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philzcodes.computer.management.model.Equipment;
import com.philzcodes.computer.management.respository.EquipmentRepository;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }
    
    public Equipment findById(Long id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipment not found"));
    }
    
    public Optional<Equipment> getEquipmentById(Long id) {
        return equipmentRepository.findById(id);
    }

    public Equipment save(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }
    
    public List<Equipment> getEquipmentHealth() {
        // Simulate fetching equipment health from the database
        List<Equipment> equipmentList = equipmentRepository.findAll();
        // You can implement custom logic here to evaluate equipment health

        // For example purposes, we'll assign random health statuses
        for (Equipment equipment : equipmentList) {
            String randomHealthStatus = getRandomHealthStatus();
            equipment.setStatus(randomHealthStatus);
        }
        return equipmentList;
    }

    private String getRandomHealthStatus() {
        // Example: Generate random health statuses for demonstration
        String[] statuses = {"Healthy", "Warning", "Critical"};
        return statuses[(int)(Math.random() * statuses.length)];
    }
}
