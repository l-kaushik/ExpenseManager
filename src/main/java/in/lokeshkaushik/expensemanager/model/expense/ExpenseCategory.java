package in.lokeshkaushik.expensemanager.model.expense;

import jakarta.persistence.*;

@Entity
public class ExpenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long expenseCategoryId;

    @Column(unique = true, nullable = false)
    private String name;

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
}
