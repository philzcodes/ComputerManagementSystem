package com.philzcodes.computer.management.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.philzcodes.computer.management.model.MaintenancePrediction;

public interface MaintenancePredictionRepository extends JpaRepository<MaintenancePrediction, Long> {
}
