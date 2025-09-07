package in.lokeshkaushik.expensemanager.basicTest;

import in.lokeshkaushik.expensemanager.model.user.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import jakarta.persistence.*;

import java.util.List;

class UserInfoTest {

    private static EntityManagerFactory emf;
    private EntityManager em;

    @BeforeAll
    static void setupClass() {
        emf = Persistence.createEntityManagerFactory("test-persistence"); // same as persistence.xml
    }

    @AfterAll
    static void tearDownClass() {
        if (emf != null) emf.close();
    }

    @BeforeEach
    void setup() {
        em = emf.createEntityManager();
    }

    @AfterEach
    void teardown() {
        if (em != null) em.close();
    }

    @Test
    void testSaveUserInfoWithRelations() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // Create entities
            UserInfo user = new UserInfo();
//            user.setUserInfoId(1L);

            FullName fullName = new FullName();
//            fullName.setFullNameId(1L);
            fullName.setFirstName("pika");
            fullName.setLastName("chu");
            fullName.setUserInfo(user);
            user.setFullNameId(fullName);

            Address addr1 = new Address();
//            addr1.setAddressId(1L);
            addr1.setUserInfo(user);
            addr1.setStreet("Street 1");
            addr1.setCity("dabok");
            addr1.setState("rajasthan");
            addr1.setZipCode("313324");

            Address addr2 = new Address();
//            addr2.setAddressId(2L);
            addr2.setUserInfo(user);
            addr2.setStreet("Street 2");

            user.setAddresses(List.of(addr1, addr2));

            // Persist user, cascade should save FullName and Addresses
            em.persist(user);

            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }

        // Test fetching
        UserInfo fetched = em.find(UserInfo.class, 1L);
        assertNotNull(fetched);
        assertNotNull(fetched.getFullNameId());
        assertEquals(2, fetched.getAddresses().size());
    }
}
