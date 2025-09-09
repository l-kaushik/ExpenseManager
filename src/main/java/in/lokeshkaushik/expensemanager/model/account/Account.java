package in.lokeshkaushik.expensemanager.model.account;

import in.lokeshkaushik.expensemanager.model.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Account {

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

    /*
    NOTE: No bi-directional mapping to transaction,
    cuz transaction can scale up to huge numbers and collection cause them loading all at once
    might add better solution later or use plain sql query encapsulated in getter method

    can use pagination like 0,100 records only etc...
     */

    // TODO: bank balance will be calculated from transaction history, but add a way to setup initial amount

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
}
