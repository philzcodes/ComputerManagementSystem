package com.philzcodes.computer.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philzcodes.computer.management.model.MaintenancePrediction;
import com.philzcodes.computer.management.respository.MaintenancePredictionRepository;

@Service
public class MaintenancePredictionService {
    @Autowired
    private MaintenancePredictionRepository predictionRepository;

    public List<MaintenancePrediction> findAll() {
        return predictionRepository.findAll();
    }

    public MaintenancePrediction save(MaintenancePrediction prediction) {
        return predictionRepository.save(prediction);
    }

    public void delete(Long id) {
        predictionRepository.deleteById(id);
    }
}
