package in.lokeshkaushik.expensemanager.model.expense;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ExpenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long expenseCategoryId;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "expenseCategory")
    private List<ExpenseInfo> expenseInfos;

    // TODO: add a better solution for fetching expenses list, cause collection fetch everything at once

    // Constructors

    protected ExpenseCategory() {}
    private ExpenseCategory(Builder builder) {
        setExpenseCategoryId(builder.expenseCategoryId);
        setName(builder.name);
        setExpenseInfos(builder.expenseInfos);
    }

    public long getExpenseCategoryId() {
        return expenseCategoryId;
    }

    public void setExpenseCategoryId(long expenseCategoryId) {
        this.expenseCategoryId = expenseCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExpenseInfo> getExpenseInfos() {
        return expenseInfos;
    }

    public void setExpenseInfos(List<ExpenseInfo> expenseInfos) {
        this.expenseInfos = expenseInfos;
    }

    // Builder

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private long expenseCategoryId;
        private String name;
        private List<ExpenseInfo> expenseInfos;

        private Builder() {
        }

        public Builder expenseCategoryId(long val) {
            expenseCategoryId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder expenseInfos(List<ExpenseInfo> val) {
            expenseInfos = val;
            return this;
        }

        public ExpenseCategory build() {
            return new ExpenseCategory(this);
        }
    }
}
