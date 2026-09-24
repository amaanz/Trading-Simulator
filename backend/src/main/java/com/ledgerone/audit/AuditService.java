package com.tradingsim.audit;

import com.tradingsim.entity.AuditAction;
import com.tradingsim.entity.AuditLog;
import com.tradingsim.entity.UserAccount;
import com.tradingsim.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditLogRepository auditLogRepository;

    public void record(UserAccount user, AuditAction action, String subject, String details, String ipAddress) {
        AuditLog log = new AuditLog();
        log.setUser(user);
        log.setAction(action);
        log.setSubject(subject);
        log.setDetails(details);
        log.setIpAddress(ipAddress);
        auditLogRepository.save(log);
    }

    public void record(UserAccount user, AuditAction action, String subject, String details) {
        record(user, action, subject, details, null);
    }
}
