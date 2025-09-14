package in.lokeshkaushik.expensemanager.model.user;

import in.lokeshkaushik.expensemanager.model.account.Account;
import in.lokeshkaushik.expensemanager.model.account.BankBranch;
import in.lokeshkaushik.expensemanager.model.expense.Expense;

import org.junit.jupiter.api.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    @BeforeAll
    static void init() {
        emf = Persistence.createEntityManagerFactory("test-persistence");
    }

    @AfterAll
    static void tearDownAll() {
        if (emf != null) emf.close();
    }

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @AfterEach
    void tearDown() {
        if (em != null) em.close();
    }

    @Test
    void testPersistAndFindUser() {
        FullName fullName = FullName.builder()
                .firstName("Jean")
                .middleName("Luc")
                .lastName("Pikachu")
                .build();

        Address address1 = Address.builder()
                .city("Los Angeles")
                .street("456 Elm Street")
                .state("CA")
                .zipCode("90001")
                .build();

        Address address2 = Address.builder()
                .city("Bournemouth")
                .street("73 Apple Road")
                .state("CA")
                .zipCode("90001")
                .build();

        UserAuth auth = UserAuth.builder()
                .passwordHash("asfl2kneorinfosknosi39")
                .email("example@email.com")
                .salt("djsfoiej@#$9df469sdfsod")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        UserInfo userInfo = UserInfo.builder()
                .fullName(fullName)
                .addresses(List.of(address1, address2))
                .brithDate(new Date(1757836172))
                .build();

        BankBranch bankBranch = BankBranch.builder()
                .IFSCCode("State Bank of India")
                .branchName("Conn aught Place")
                .branchCode("00691")
                .build();

        Account account1 = Account.builder()
                .accountNumber(1122334455)
                .bankBranch(bankBranch)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Account account2 = Account.builder()
                .accountNumber(1234123412)
                .bankBranch(bankBranch)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        User user = User.builder()
                .username("Lokesh")
                .userAuth(auth)
                .userInfo(userInfo)
                .accounts(List.of(account1, account2))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        fullName.setUserInfo(userInfo);
        address1.setUserInfo(userInfo);
        address2.setUserInfo(userInfo);
        auth.setUser(user);
        bankBranch.setAccounts(List.of(account1, account2));
        account1.setUser(user);
        account2.setUser(user);
        userInfo.setUser(user);

        tx.begin();
        em.persist(bankBranch);
        em.persist(user);
        tx.commit();

        em.clear(); // clear cache so we fetch from DB

        User found = em.find(User.class, user.getUserId());

        assertNotNull(found);
        assertEquals(user, found);
        assertEquals("Lokesh", found.getUsername());
        assertNotNull(found.getUserAuth());
        assertNotNull(found.getUserInfo());
        assertEquals(2, found.getAccounts().size());
//        assertEquals(1, found.getExpenses().size());
    }
}
