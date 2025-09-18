package in.lokeshkaushik.expensemanager.utils;

import in.lokeshkaushik.expensemanager.model.user.User;
import in.lokeshkaushik.expensemanager.model.user.*;
import in.lokeshkaushik.expensemanager.model.account.*;
import in.lokeshkaushik.expensemanager.model.expense.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestDataFactory {

    public static FullName createFullName() {
        return FullName.builder()
                .firstName("Jean")
                .middleName("Luc")
                .lastName("Pikachu")
                .build();
    }

    public static Address createAddress(String street, String city) {
        return Address.builder()
                .city(city)
                .street(street)
                .state("CA")
                .zipCode("90001")
                .build();
    }

    public static UserAuth createUserAuth() {
        return UserAuth.builder()
                .passwordHash("hash123")
                .email("example@email.com")
                .salt("salt456")
                .build();
    }

    public static BankBranch createBankBranch() {
        return BankBranch.builder()
                .IFSCCode("SBI001")
                .branchName("Connaught Place")
                .branchCode("00691")
                .build();
    }

    public static Account createAccount(BankBranch bankBranch, long number) {
        return Account.builder()
                .accountNumber(number)
                .bankBranch(bankBranch)
                .build();
    }

    public static UserInfo createUserInfo(){
        return UserInfo.builder()
                .fullName(createFullName())
                .addresses(List.of(createAddress("123 street", "San Jose"),
                        createAddress("234 street", "San Francisco")))
                .birthDate(new Date())
                .build();
    }

    public static List<Expense> createExpenses(Account sender, Account receiver, User user, ExpenseCategory category) {
        List<Expense> expenses = new ArrayList<>();
        List<ExpenseInfo> expenseInfos = new ArrayList<>();

        // Example expenses
        for (int i = 1; i <= 5; i++) {
            // Create Expense first
            Expense expense = Expense.builder()
                    .user(user)
                    .build();

            // Create Transaction linked to expense
            Transaction transaction = Transaction.builder()
                    .senderAccount(sender)
                    .receiverAccount(receiver)
                    .expense(expense) // link transaction -> expense
                    .transactionType(TransactionType.CREDIT)
                    .paymentStatus(PaymentStatus.SUCCESS)
                    .paymentMethod(PaymentMethod.UPI)
                    .remark("Test transaction " + i)
                    .amount(BigDecimal.valueOf(100 * i))
                    .build();

            // Create ExpenseInfo linked to expense
            ExpenseInfo expenseInfo = ExpenseInfo.builder()
                    .expense(expense)
                    .expenseCategory(category)
                    .description("Test expense info " + i)
                    .build();

            // Wire back relations
            expense.setTransaction(transaction);
            expense.setExpenseInfo(expenseInfo);
            expenseInfos.add(expenseInfo);

            expenses.add(expense);
        }
        category.setExpenseInfos(expenseInfos);

        return expenses;
    }

    public static User createUser() {
        FullName fullName = createFullName();
        Address address1 = createAddress("456 Elm Street", "Los Angeles");
        Address address2 = createAddress("73 Apple Road", "Oakland");

        UserAuth auth = createUserAuth();
        UserInfo userInfo = UserInfo.builder()
                .addresses(List.of(address1, address2))
                .fullName(fullName)
                .birthDate(new Date())
                .build();

        BankBranch branch = createBankBranch();
        Account account1 = createAccount(branch, 1122334455);
        Account account2 = createAccount(branch, 1234123412);

        User user = User.builder()
                .username("Lokesh")
                .userAuth(auth)
                .userInfo(userInfo)
                .accounts(List.of(account1, account2))
                .build();

        ExpenseCategory expenseCategory = ExpenseCategory.builder().name("test").build();

        List<Expense> expenses = createExpenses(account1, account2, user, expenseCategory);

        // link both sides
        fullName.setUserInfo(userInfo);
        address1.setUserInfo(userInfo);
        address2.setUserInfo(userInfo);
        auth.setUser(user);
        branch.setAccounts(List.of(account1, account2));
        account1.setUser(user);
        account2.setUser(user);
        userInfo.setUser(user);
        user.setExpenses(expenses);

        return user;
    }
}
