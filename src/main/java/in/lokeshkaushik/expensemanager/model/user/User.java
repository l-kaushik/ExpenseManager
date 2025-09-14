package in.lokeshkaushik.expensemanager.model.user;

import in.lokeshkaushik.expensemanager.model.account.Account;
import in.lokeshkaushik.expensemanager.model.base.Identifiable;
import in.lokeshkaushik.expensemanager.model.expense.Expense;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")  // avoid reserved keyword
public class User implements Identifiable {
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
    @OneToMany(mappedBy = "user")
    private List<Expense> expenses;

    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column(unique = true, nullable = false, updatable = false)
    private String uuid = UUID.randomUUID().toString();

    // Constructors
    protected User(){}

    private User(Builder builder) {
        setUserId(builder.userId);
        setUserAuth(builder.userAuth);
        setAccounts(builder.accounts);
        setUserInfo(builder.userInfo);
        setExpenses(builder.expenses);
        setUsername(builder.username);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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

    public String getUuid(){
        return uuid;
    }

    private void setUuid(String uuid){
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uuid.equals(user.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
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
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

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

        public Builder createdAt(LocalDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(LocalDateTime val) {
            updatedAt = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
