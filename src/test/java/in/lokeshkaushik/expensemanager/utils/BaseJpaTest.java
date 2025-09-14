package in.lokeshkaushik.expensemanager.utils;

import in.lokeshkaushik.expensemanager.model.base.Identifiable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseJpaTest {
    protected static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;  // not static so we can have separate for each session
    protected EntityTransaction entityTransaction;

    @BeforeAll
    static void init(){
        entityManagerFactory = Persistence.createEntityManagerFactory("test-persistence");
    }

    @AfterAll
    static void tearDownAll() {
        if(entityManagerFactory != null) entityManagerFactory.close();
    }

    @BeforeEach
    void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
    }

    @AfterEach
    void tearDown() {
        if(entityTransaction.isActive()) entityTransaction.rollback();
        if(entityManager != null) entityManager.close();
    }

    protected<T extends Identifiable> T PersistAndFetch(Class<T> tClass, T entity) {
        entityManager.persist(entity);
//        entityTransaction.commit();
        entityManager.flush();  // force sql insert/update
        entityManager.clear(); // force fresh fetch

        return entityManager.find(tClass, entity.getId());
    }
}
