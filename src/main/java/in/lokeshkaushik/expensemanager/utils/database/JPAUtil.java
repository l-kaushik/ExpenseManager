package in.lokeshkaushik.expensemanager.utils.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
   private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistence");

   public static EntityManager getEntityManager() {
       return entityManagerFactory.createEntityManager();
   }

   public static void close(){
       entityManagerFactory.close();
   }
}
