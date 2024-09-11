package com.philzcodes.computer.management.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.philzcodes.computer.management.model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
