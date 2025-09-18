package in.lokeshkaushik.expensemanager.model.user;

import in.lokeshkaushik.expensemanager.model.account.Account;
import in.lokeshkaushik.expensemanager.model.base.AuditListener;
import in.lokeshkaushik.expensemanager.model.base.AuditableEntity;
import in.lokeshkaushik.expensemanager.model.base.Identifiable;
import in.lokeshkaushik.expensemanager.model.expense.Expense;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")  // avoid reserved keyword
@EntityListeners(AuditListener.class)
public class User extends AuditableEntity implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    // NOTE: Since its personal expense tracker, removing transaction entries won't matter that much,
    // but if add support for shared transaction or syncing this online, then reconsider the orphan removal
    // since removing 1 account will mess up entries for others as well.

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserAuth userAuth;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserInfo userInfo;

    // TODO: add cascading and orphan removal in service layer
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Expense> expenses;

    private String username;

    // Constructors
    protected User(){}

    private User(Builder builder) {
        setUserId(builder.userId);
        setUserAuth(builder.userAuth);
        setAccounts(builder.accounts);
        setUserInfo(builder.userInfo);
        setExpenses(builder.expenses);
        setUsername(builder.username);
    }

    // Getters and Setters

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserAuth getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(UserAuth userAuth) {
        this.userAuth = userAuth;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public Long getId() {
        return userId;
    }

    // Builder

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private long userId;
        private UserAuth userAuth;
        private List<Account> accounts;
        private UserInfo userInfo;
        private List<Expense> expenses;
        private String username;

        private Builder() {
        }

        public Builder userId(long val) {
            userId = val;
            return this;
        }

        public Builder userAuth(UserAuth val) {
            userAuth = val;
            return this;
        }

        public Builder accounts(List<Account> val) {
            accounts = val;
            return this;
        }

        public Builder userInfo(UserInfo val) {
            userInfo = val;
            return this;
        }

        public Builder expenses(List<Expense> val) {
            expenses = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
