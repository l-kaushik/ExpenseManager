package in.lokeshkaushik.expensemanager.model.base;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.Instant;

public class AuditListener {
    @PrePersist
    protected void setCreatedOn(Object entity) {
        if(entity instanceof Auditable auditable){
            auditable.setCreatedAt(Instant.now());
            auditable.setUpdatedAt(Instant.now());
        }
    }

    @PreUpdate
    protected void setUpdatedOn(Object entity) {
        if(entity instanceof Auditable auditable) {
            auditable.setUpdatedAt(Instant.now());
        }
    }
}
