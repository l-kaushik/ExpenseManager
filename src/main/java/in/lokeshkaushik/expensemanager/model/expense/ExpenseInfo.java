package in.lokeshkaushik.expensemanager.model.expense;

import in.lokeshkaushik.expensemanager.model.base.BaseEntity;
import in.lokeshkaushik.expensemanager.model.base.Identifiable;
import jakarta.persistence.*;

@Entity
public class ExpenseInfo extends BaseEntity implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long expenseInfoId;

    @ManyToOne
    @JoinColumn(name = "expense_category_id", nullable = true)
    private ExpenseCategory expenseCategory;

    @OneToOne
    @JoinColumn(name = "expense_id", nullable = false)
    private Expense expense;

    private String description;

    // Constructors
    protected ExpenseInfo(){}

    private ExpenseInfo(Builder builder) {
        setExpenseInfoId(builder.expenseInfoId);
        setExpenseCategory(builder.expenseCategory);
        setExpense(builder.expense);
        setDescription(builder.description);
    }

    // Getter and Setter

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Long getId() {
        return expenseInfoId;
    }

    // Builder

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private long expenseInfoId;
        private ExpenseCategory expenseCategory;
        private Expense expense;
        private String description;

        private Builder() {
        }

        public Builder expenseInfoId(long val) {
            expenseInfoId = val;
            return this;
        }

        public Builder expenseCategory(ExpenseCategory val) {
            expenseCategory = val;
            return this;
        }

        public Builder expense(Expense val) {
            expense = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public ExpenseInfo build() {
            return new ExpenseInfo(this);
        }
    }
}
