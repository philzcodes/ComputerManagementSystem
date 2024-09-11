package com.philzcodes.computer.management.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.philzcodes.computer.management.model.WorkOrder;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
}
