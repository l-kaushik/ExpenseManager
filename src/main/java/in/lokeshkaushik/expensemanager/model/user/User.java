package in.lokeshkaushik.expensemanager.model.user;

import in.lokeshkaushik.expensemanager.model.account.Account;
import in.lokeshkaushik.expensemanager.model.expense.Expense;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    // NOTE: Since its personal expense tracker, removing transaction entries won't matter that much,
    // but if add support for shared transaction or syncing this online, then reconsider the orphan removal
    // since removing 1 account will mess up entries for others as well.

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(nullable = false)
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

    // Default Constructor
    protected User(){}

    // Builder
    public static class Builder {
        private final User user;

        public Builder() {
            this.user = new User();
        }

        public Builder username(String username){
            user.setUsername(username);
            return this;
        }

        public  Builder userAuth(UserAuth userAuth) {
            user.setUserAuth(userAuth);
            return this;
        }

        public Builder userInfo(UserInfo userInfo){
            user.setUserInfo(userInfo);
            return this;
        }

        public User build(){
            user.setCreatedAt(LocalDateTime.now());
            user.setUpdatedAt(LocalDateTime.now());
            return user;
        }

    }

    // Getters and Setters

    public static Builder builder() {
        return new Builder();
    }

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
}
