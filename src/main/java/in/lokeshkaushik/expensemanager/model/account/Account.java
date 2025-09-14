package in.lokeshkaushik.expensemanager.model.account;

import in.lokeshkaushik.expensemanager.model.base.Identifiable;
import in.lokeshkaushik.expensemanager.model.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Account implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "branch_id") // FK column in account table
    private BankBranch bankBranch;

    private long accountNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors

    protected Account() {}

    private Account(Builder builder) {
        setAccountId(builder.accountId);
        setUser(builder.user);
        setBankBranch(builder.bankBranch);
        setAccountNumber(builder.accountNumber);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
    }

    /*
    NOTE: No bi-directional mapping to transaction,
    cuz transaction can scale up to huge numbers and collection cause them loading all at once
    might add better solution later or use plain sql query encapsulated in getter method

    can use pagination like 0,100 records only etc...
     */

    // TODO: bank balance will be calculated from transaction history, but add a way to setup initial amount

    // Getters and Setters

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Long getId() {
        return accountId;
    }

    // Builder

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private long accountId;
        private User user;
        private BankBranch bankBranch;
        private long accountNumber;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private Builder() {
        }

        public Builder accountId(long val) {
            accountId = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder bankBranch(BankBranch val) {
            bankBranch = val;
            return this;
        }

        public Builder accountNumber(long val) {
            accountNumber = val;
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

        public Account build() {
            return new Account(this);
        }
    }
}
