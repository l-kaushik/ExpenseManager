package in.lokeshkaushik.expensemanager.model.user;

import in.lokeshkaushik.expensemanager.model.account.Account;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(nullable = false)
    private UserAuth userAuth;

    // TODO: User can have multiple account
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Account account;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserInfo userInfo;

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
