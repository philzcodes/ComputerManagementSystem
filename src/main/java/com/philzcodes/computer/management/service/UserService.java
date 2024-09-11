package com.philzcodes.computer.management.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philzcodes.computer.management.model.AuditLog;
import com.philzcodes.computer.management.model.User;
import com.philzcodes.computer.management.respository.AuditLogRepository;
import com.philzcodes.computer.management.respository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuditLogRepository auditLogRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User save(User user) {
        // Save the user
        User savedUser = userRepository.save(user);

        // Log the action in the audit log
        AuditLog auditLog = new AuditLog();
        auditLog.setDate(LocalDateTime.now().toString());
        auditLog.setUsername(user.getName());
        auditLog.setAction(user.getId() == null ? "Created User" : "Updated User");
        auditLogRepository.save(auditLog);

        return savedUser;
    }

    public void delete(Long id) {
        User user = findById(id); // Fetch the user to log the deletion

        // Delete the user
        userRepository.deleteById(id);

        // Log the action in the audit log
        AuditLog auditLog = new AuditLog();
        auditLog.setDate(LocalDateTime.now().toString());
        auditLog.setUsername(user.getName());
        auditLog.setAction("Deleted User");
        auditLogRepository.save(auditLog);
    }

    public List<AuditLog> getAuditLogs() {
        return auditLogRepository.findAll();
    }
}
