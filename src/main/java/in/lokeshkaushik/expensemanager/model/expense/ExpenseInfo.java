package in.lokeshkaushik.expensemanager.model.expense;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ExpenseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long expenseInfoId;

    @ManyToOne
    @JoinColumn(name = "expense_category_id", nullable = false)
    private ExpenseCategory expenseCategory;

    @OneToOne
    @JoinColumn(name = "expense_id", nullable = false)
    private Expense expense;

    private LocalDateTime timestamp;
    private String description;

    public long getExpenseInfoId() {
        return expenseInfoId;
    }

    public void setExpenseInfoId(long expenseInfoId) {
        this.expenseInfoId = expenseInfoId;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
