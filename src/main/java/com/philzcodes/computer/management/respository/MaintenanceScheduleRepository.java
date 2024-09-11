package com.philzcodes.computer.management.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.philzcodes.computer.management.model.MaintenanceSchedule;

public interface MaintenanceScheduleRepository extends JpaRepository<MaintenanceSchedule, Long> {
}
