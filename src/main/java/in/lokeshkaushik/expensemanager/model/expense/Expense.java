package in.lokeshkaushik.expensemanager.model.expense;

import in.lokeshkaushik.expensemanager.model.account.Transaction;
import in.lokeshkaushik.expensemanager.model.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long expenseId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(mappedBy = "expense", cascade = CascadeType.ALL, orphanRemoval = true)
    private Transaction transaction;

    @OneToOne(mappedBy = "expense", cascade = CascadeType.ALL, orphanRemoval = true)
    private ExpenseInfo expenseInfo;

    private LocalDateTime createdAt;

    public long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(long expenseId) {
        this.expenseId = expenseId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public ExpenseInfo getExpenseInfo() {
        return expenseInfo;
    }

    public void setExpenseInfo(ExpenseInfo expenseInfo) {
        this.expenseInfo = expenseInfo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
