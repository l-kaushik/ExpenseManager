package in.lokeshkaushik.expensemanager.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Column(unique = true, nullable = false, updatable = false)
    private final String uuid = UUID.randomUUID().toString();

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity baseEntity = (BaseEntity) o;
        return uuid.equals(baseEntity.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
