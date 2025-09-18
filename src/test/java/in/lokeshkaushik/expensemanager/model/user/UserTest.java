package in.lokeshkaushik.expensemanager.model.user;

import in.lokeshkaushik.expensemanager.model.account.Account;
import in.lokeshkaushik.expensemanager.model.account.BankBranch;
import in.lokeshkaushik.expensemanager.model.account.Transaction;
import in.lokeshkaushik.expensemanager.model.expense.Expense;
import in.lokeshkaushik.expensemanager.model.expense.ExpenseCategory;
import in.lokeshkaushik.expensemanager.model.expense.ExpenseInfo;
import in.lokeshkaushik.expensemanager.utils.BaseJpaTest;
import in.lokeshkaushik.expensemanager.utils.TestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest extends BaseJpaTest {
    private User user;
    private User found;

    @BeforeEach
    void setUp() {
        user = TestDataFactory.createUser();
        PersistAndFetch(ExpenseCategory.class, user.getExpenses().get(0).getExpenseInfo().getExpenseCategory());
        found = PersistAndFetch(User.class, user);
    }

    @Test
    void testUser() {
        assertNotNull(user, "User object shouldn't be null");
        assertNotNull(found,  "found object which is user fetched from db, shouldn't be null as well");
        assertEquals(user, found, "user and found should have same UUID");
        assertEquals(user.getUsername(), found.getUsername());
        assertEquals(user.getCreatedAt().truncatedTo(ChronoUnit.MILLIS), found.getCreatedAt().truncatedTo(ChronoUnit.MILLIS));
        assertEquals(user.getUpdatedAt().truncatedTo(ChronoUnit.MILLIS), found.getUpdatedAt().truncatedTo(ChronoUnit.MILLIS));
    }

    @Test
    void testAddress() {
        List<Address> addresses = user.getUserInfo().getAddresses();
        List<Address> foundAddresses = found.getUserInfo().getAddresses();

        assertNotNull(addresses, "Addresses list should not be null");
        assertNotNull(foundAddresses, "Found address list should not be null");
        assertEquals(addresses.size(), foundAddresses.size(), "Both list should have the same size");
        assertTrue(addresses.stream().allMatch(Objects::nonNull), "All addresses should be non-null");
        assertTrue(foundAddresses.stream().allMatch(Objects::nonNull), "All found addresses should be non-null");
    }

    @Test
    void testFullName() {
        FullName name = user.getUserInfo().getFullName();
        FullName foundName = found.getUserInfo().getFullName();

        assertNotNull( name);
        assertNotNull(foundName);
        assertEquals(name, foundName);
        assertEquals(name.getFirstName(), foundName.getFirstName());
        assertEquals(name.getMiddleName(), foundName.getMiddleName());
        assertEquals(name.getLastName(), foundName.getLastName());
    }

    @Test
    void testUserAuth() {
        UserAuth userAuth = user.getUserAuth();
        UserAuth foundUserAuth = found.getUserAuth();

        assertEquals(userAuth, foundUserAuth, "Both UserAuth objects should be equal by UUID");
        assertEquals(userAuth.getUserAuthId(), foundUserAuth.getUserAuthId(), "IDs should match");
        assertEquals(userAuth.getUser(), foundUserAuth.getUser(), "User should match");
        assertEquals(userAuth.getPasswordHash(), foundUserAuth.getPasswordHash(), "Password hash should match");
        assertEquals(userAuth.getSalt(), foundUserAuth.getSalt(), "Salt should match");
        assertEquals(userAuth.getEmail(), foundUserAuth.getEmail(), "Email should match");
        assertEquals(userAuth.getLastLogin(), foundUserAuth.getLastLogin(), "Last login should match");
        assertEquals(userAuth.getCreatedAt().truncatedTo(ChronoUnit.MILLIS), foundUserAuth.getCreatedAt().truncatedTo(ChronoUnit.MILLIS));
        assertEquals(userAuth.getUpdatedAt().truncatedTo(ChronoUnit.MILLIS), foundUserAuth.getUpdatedAt().truncatedTo(ChronoUnit.MILLIS));
    }

    @Test
    void testUserInfo() {
        UserInfo userInfo = user.getUserInfo();
        UserInfo foundUserInfo = found.getUserInfo();

        assertNotNull(userInfo, "userInfo should not be null");
        assertNotNull(foundUserInfo, "foundUserInfo should not be null");

        assertEquals(userInfo, foundUserInfo, "Both UserInfo objects should be equal by UUID");

        assertEquals(userInfo.getUserInfoId(), foundUserInfo.getUserInfoId(), "userInfoId should match");
        assertEquals(userInfo.getUser(), foundUserInfo.getUser(), "User should match");
        assertEquals(userInfo.getFullName(), foundUserInfo.getFullName(), "FullName should match");
        assertEquals(userInfo.getBirthDate(), foundUserInfo.getBirthDate(), "BirthDate should match");

        assertEquals(userInfo.getAddresses().size(), foundUserInfo.getAddresses().size(), "Addresses list size should match");
        for (int i = 0; i < userInfo.getAddresses().size(); i++) {
            Address expected = userInfo.getAddresses().get(i);
            Address actual = foundUserInfo.getAddresses().get(i);

            assertEquals(expected, actual, "Address at index " + i + " should match by UUID");
            assertEquals(expected.getStreet(), actual.getStreet(), "Street should match at index " + i);
            assertEquals(expected.getCity(), actual.getCity(), "City should match at index " + i);
            assertEquals(expected.getZipCode(), actual.getZipCode(), "Zip code should match at index " + i);
        }
    }

    @Test
    void testAccounts() {
        List<Account> accounts = user.getAccounts();
        List<Account> foundAccounts = found.getAccounts();

        assertNotNull(accounts, "Accounts list should not be null");
        assertNotNull(foundAccounts, "Found accounts list should not be null");

        assertEquals(accounts.size(), foundAccounts.size(), "Account list sizes should match");

        for (int i = 0; i < accounts.size(); i++) {
            Account expected = accounts.get(i);
            Account actual = foundAccounts.get(i);

            // BaseEntity equality (UUID)
            assertEquals(expected, actual, "Accounts should match by UUID at index " + i);

            // Field-by-field equality
            assertEquals(expected.getAccountId(), actual.getAccountId(), "AccountId should match at index " + i);
            assertEquals(expected.getUser(), actual.getUser(), "User should match at index " + i);
            assertEquals(expected.getBankBranch(), actual.getBankBranch(), "BankBranch should match at index " + i);
            assertEquals(expected.getAccountNumber(), actual.getAccountNumber(), "AccountNumber should match at index " + i);
            assertEquals(expected.getCreatedAt().truncatedTo(ChronoUnit.MILLIS), actual.getCreatedAt().truncatedTo(ChronoUnit.MILLIS));
            assertEquals(expected.getUpdatedAt().truncatedTo(ChronoUnit.MILLIS), actual.getUpdatedAt().truncatedTo(ChronoUnit.MILLIS));

        }
    }

    @Test
    void testBankBranch() {
        List<Account> accounts = user.getAccounts();
        List<Account> foundAccounts = found.getAccounts();

        for(int i = 0 ; i < accounts.size(); i++){
            BankBranch bankBranch = accounts.get(i).getBankBranch();
            BankBranch foundBankBranch = foundAccounts.get(i).getBankBranch();

            assertNotNull(bankBranch, "bankBranch should not be null");
            assertNotNull(foundBankBranch, "foundBankBranch should not be null");
            assertEquals(bankBranch, foundBankBranch, "Branches should be equal by UUID");
            assertEquals(bankBranch.getBranchId(), foundBankBranch.getBranchId(), "BranchId should match");
            assertEquals(bankBranch.getIFSCCode(), foundBankBranch.getIFSCCode(), "IFSCCode should match");
            assertEquals(bankBranch.getBranchCode(), foundBankBranch.getBranchCode(), "BranchCode should match");
            assertEquals(bankBranch.getBranchName(), foundBankBranch.getBranchName(), "BranchName should match");
            assertNotNull(bankBranch.getAccounts(), "Accounts list should not be null");
            assertNotNull(foundBankBranch.getAccounts(), "Found accounts list should not be null");
            assertEquals(bankBranch.getAccounts().size(), foundBankBranch.getAccounts().size(), "Accounts list size should match");
        }
    }

    @Test
    void testExpenseWithTransactionAndInfo() {

        List<Expense> expenses = user.getExpenses();
        List<Expense> foundExpenses = found.getExpenses();

        assertNotNull(expenses, "User expenses should not be null");
        assertNotNull(foundExpenses, "Found expenses should not be null");
        assertEquals(expenses.size(), foundExpenses.size(), "Expense list sizes should match");

        for (int i = 0; i < expenses.size(); i++) {
            Expense expense = expenses.get(i);
            Expense foundExpense = foundExpenses.get(i);

            assertNotNull(expense, "Expense at index " + i + " should not be null");
            assertNotNull(foundExpense, "Found expense at index " + i + " should not be null");
            assertEquals(expense.getUser(), foundExpense.getUser(),
                    "Users should match for expense at index " + i);

            // Transaction checks
            Transaction tx = expense.getTransaction();
            Transaction foundTx = foundExpense.getTransaction();

            assertNotNull(tx, "Transaction should not be null for expense at index " + i);
            assertNotNull(foundTx, "Found transaction should not be null for expense at index " + i);
            assertEquals(tx.getAmount().doubleValue(), foundTx.getAmount().doubleValue(),
                    "Transaction amount should match for expense at index " + i);
            assertEquals(tx.getRemark(), foundTx.getRemark(),
                    "Transaction remark should match for expense at index " + i);
            assertEquals(tx.getTransactionType(), foundTx.getTransactionType(),
                    "Transaction type should match for expense at index " + i);
            assertEquals(tx.getPaymentStatus(), foundTx.getPaymentStatus(),
                    "Payment status should match for expense at index " + i);
            assertEquals(tx.getPaymentMethod(), foundTx.getPaymentMethod(),
                    "Payment method should match for expense at index " + i);
            assertEquals(tx.getSenderAccount(), foundTx.getSenderAccount(),
                    "Sender account should match for expense at index " + i);
            assertEquals(tx.getReceiverAccount(), foundTx.getReceiverAccount(),
                    "Receiver account should match for expense at index " + i);

            // ExpenseInfo checks
            ExpenseInfo info = expense.getExpenseInfo();
            ExpenseInfo foundInfo = foundExpense.getExpenseInfo();

            assertNotNull(info, "ExpenseInfo should not be null for expense at index " + i);
            assertNotNull(foundInfo, "Found ExpenseInfo should not be null for expense at index " + i);
            assertEquals(info.getDescription(), foundInfo.getDescription(),
                    "Expense description should match for expense at index " + i);
            assertEquals(info.getExpenseCategory(), foundInfo.getExpenseCategory(),
                    "Expense category should match for expense at index " + i);
        }
    }

}
