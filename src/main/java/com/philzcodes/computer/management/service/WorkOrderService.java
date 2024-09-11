package com.philzcodes.computer.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philzcodes.computer.management.model.WorkOrder;
import com.philzcodes.computer.management.respository.WorkOrderRepository;

@Service
public class WorkOrderService {

    @Autowired
    private WorkOrderRepository workOrderRepository;

    public List<WorkOrder> findAll() {
        return workOrderRepository.findAll();
    }

    public Optional<WorkOrder> findById(Long id) {
        return workOrderRepository.findById(id);
    }

    public WorkOrder save(WorkOrder workOrder) {
        return workOrderRepository.save(workOrder);
    }

    public void delete(Long id) {
        workOrderRepository.deleteById(id);
    }
}
