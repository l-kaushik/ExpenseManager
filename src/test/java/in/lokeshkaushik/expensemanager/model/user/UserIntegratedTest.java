package in.lokeshkaushik.expensemanager.model.user;

import in.lokeshkaushik.expensemanager.model.account.Account;
import in.lokeshkaushik.expensemanager.model.account.BankBranch;

import in.lokeshkaushik.expensemanager.utils.BaseJpaTest;
import org.junit.jupiter.api.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserIntegratedTest extends BaseJpaTest {

    @Test
    void testPersistAndFindUser() {
        FullName fullName = FullName.builder()
                .firstName("Ian")
                .middleName("John")
                .lastName("Marr")
                .build();

        Address address1 = Address.builder()
                .city("Angeles Los")
                .street("456 Elm Street")
                .state("AC")
                .zipCode("90001")
                .build();

        Address address2 = Address.builder()
                .city("Bournemouth")
                .street("73 Android Road")
                .state("AC")
                .zipCode("70002")
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
                .birthDate(new Date(1757836172))
                .build();

        BankBranch bankBranch = BankBranch.builder()
                .IFSCCode("State Bank of USA")
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

        User found = PersistAndFetch(User.class, user);

        assertNotNull(found);
        assertEquals(user, found);
        assertEquals("Lokesh", found.getUsername());
        assertNotNull(found.getUserAuth());
        assertNotNull(found.getUserInfo());
        assertEquals(2, found.getAccounts().size());
//        assertEquals(1, found.getExpenses().size());
    }
}
