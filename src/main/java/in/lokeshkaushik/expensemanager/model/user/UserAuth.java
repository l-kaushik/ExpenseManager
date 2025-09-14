package in.lokeshkaushik.expensemanager.model.user;

import in.lokeshkaushik.expensemanager.model.base.Identifiable;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class UserAuth implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userAuthId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private String passwordHash;
    private String salt;

    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;
    private LocalDateTime updatedAt;

    // Constructors

    protected UserAuth() {}

    private UserAuth(Builder builder) {
        setUserAuthId(builder.userAuthId);
        setUser(builder.user);
        setPasswordHash(builder.passwordHash);
        setSalt(builder.salt);
        setEmail(builder.email);
        setCreatedAt(builder.createdAt);
        setLastLogin(builder.lastLogin);
        setUpdatedAt(builder.updatedAt);
    }

    public long getUserAuthId() {
        return userAuthId;
    }

    public void setUserAuthId(long userAuthId) {
        this.userAuthId = userAuthId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public Long getId() {
        return userAuthId;
    }

    // Builder

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private long userAuthId;
        private User user;
        private String passwordHash;
        private String salt;
        private String email;
        private LocalDateTime createdAt;
        private LocalDateTime lastLogin;
        private LocalDateTime updatedAt;

        private Builder() {
        }

        public Builder userAuthId(long val) {
            userAuthId = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder passwordHash(String val) {
            passwordHash = val;
            return this;
        }

        public Builder salt(String val) {
            salt = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder createdAt(LocalDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder lastLogin(LocalDateTime val) {
            lastLogin = val;
            return this;
        }

        public Builder updatedAt(LocalDateTime val) {
            updatedAt = val;
            return this;
        }

        public UserAuth build() {
            return new UserAuth(this);
        }
    }
}
