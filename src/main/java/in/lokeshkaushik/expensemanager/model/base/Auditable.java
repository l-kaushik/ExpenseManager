package in.lokeshkaushik.expensemanager.model.base;

import java.time.Instant;

public interface Auditable {
    Instant getCreatedAt();
    Instant getUpdatedAt();

    void setCreatedAt(Instant createdAt);
    void setUpdatedAt(Instant updatedAt);
}
