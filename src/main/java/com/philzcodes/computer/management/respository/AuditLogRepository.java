package com.philzcodes.computer.management.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philzcodes.computer.management.model.AuditLog;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    // Additional query methods for custom audit log filtering can be added here if necessary
}
