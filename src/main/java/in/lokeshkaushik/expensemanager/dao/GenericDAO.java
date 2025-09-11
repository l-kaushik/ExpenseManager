package in.lokeshkaushik.expensemanager.dao;

import in.lokeshkaushik.expensemanager.utils.database.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class GenericDAO<T> {
    private final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(T entity){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try (em) {
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (Exception e) { // TODO: Implement custom exceptions
            if (tx.isActive()) tx.rollback();
            System.out.printf("Generic DAO - save(): " + e.getMessage());
            throw e;
        }
    }

    public T find(Object id) {
        EntityManager em = JPAUtil.getEntityManager();
        try (em) {
            return em.find(entityClass, id);
        } catch (Exception e) { // TODO: Implement custom exceptions
            System.out.printf("Generic DAO - find(): " + e.getMessage());
            throw e;
        }
    }

    public void remove(Object id){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try (em) {
            tx.begin();
            T entity = em.find(entityClass, id);
            if(entity != null) em.remove(entity);    // TODO: Add notifier to notify about deletion
            tx.commit();
        } catch (Exception e) { // TODO: Implement custom exceptions
            if (tx.isActive()) tx.rollback();
            System.out.printf("Generic DAO - remove(): " + e.getMessage());
            throw e;
        }
    }
}
