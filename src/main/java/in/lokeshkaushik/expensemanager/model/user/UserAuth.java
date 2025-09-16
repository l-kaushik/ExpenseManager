package in.lokeshkaushik.expensemanager.model.user;

import in.lokeshkaushik.expensemanager.model.base.AuditListener;
import in.lokeshkaushik.expensemanager.model.base.AuditableEntity;
import in.lokeshkaushik.expensemanager.model.base.Identifiable;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@EntityListeners(AuditListener.class)
public class UserAuth extends AuditableEntity implements Identifiable {
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
    private Instant lastLogin;

    // Constructors

    protected UserAuth() {}

    private UserAuth(Builder builder) {
        setUserAuthId(builder.userAuthId);
        setUser(builder.user);
        setPasswordHash(builder.passwordHash);
        setSalt(builder.salt);
        setEmail(builder.email);
        setLastLogin(builder.lastLogin);
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

    public Instant getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
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
        private Instant lastLogin;

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


        public Builder lastLogin(Instant val) {
            lastLogin = val;
            return this;
        }

        public UserAuth build() {
            return new UserAuth(this);
        }
    }
}
