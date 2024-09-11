package com.philzcodes.computer.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.philzcodes.computer.management.model.WorkOrder;
import com.philzcodes.computer.management.service.WorkOrderService;

@Controller
public class WorkOrderController {

    @Autowired
    private WorkOrderService workOrderService;

    @GetMapping("/workorders")
    public String getAllWorkOrders(Model model) {
        model.addAttribute("workOrders", workOrderService.findAll());
        return "work-orders";  // Refers to the Thymeleaf template
    }

    @PostMapping("/workorders/add")
    public String addWorkOrder(@ModelAttribute WorkOrder workOrder) {
        workOrderService.save(workOrder);
        return "redirect:/workorders";  // Redirect to work orders page after saving
    }

    @GetMapping("/workorders/edit/{id}")
    @ResponseBody  // Return WorkOrder as JSON for editing
    public WorkOrder getWorkOrderById(@PathVariable Long id) {
        return workOrderService.findById(id).orElseThrow(() -> new RuntimeException("Work Order not found"));
    }

    @PostMapping("/workorders/edit/{id}")
    public String updateWorkOrder(@PathVariable Long id, @ModelAttribute WorkOrder workOrder) {
        workOrder.setId(id);
        workOrderService.save(workOrder);
        return "redirect:/workorders";
    }

    @DeleteMapping("/workorders/delete/{id}")
    @ResponseBody
    public String deleteWorkOrder(@PathVariable Long id) {
        workOrderService.delete(id);
        return "Work Order deleted successfully";
    }
}
