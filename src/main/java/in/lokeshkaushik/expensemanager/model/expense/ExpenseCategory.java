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

    public ExpenseCategory() {}
    public ExpenseCategory(String name){
        this.name = name;
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
}
