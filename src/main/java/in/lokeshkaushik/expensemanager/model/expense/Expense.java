package in.lokeshkaushik.expensemanager.model.expense;

import in.lokeshkaushik.expensemanager.model.account.Transaction;
import in.lokeshkaushik.expensemanager.model.base.BaseEntity;
import in.lokeshkaushik.expensemanager.model.base.Identifiable;
import in.lokeshkaushik.expensemanager.model.user.User;
import jakarta.persistence.*;

@Entity
public class Expense extends BaseEntity implements Identifiable {

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

    // Constructors

    protected Expense() {}

    private Expense(Builder builder) {
        setExpenseId(builder.expenseId);
        setUser(builder.user);
        setTransaction(builder.transaction);
        setExpenseInfo(builder.expenseInfo);
    }

    // Getter and Setters

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

    @Override
    public Long getId() {
        return expenseId;
    }

    // Builder

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private long expenseId;
        private User user;
        private Transaction transaction;
        private ExpenseInfo expenseInfo;

        private Builder() {
        }

        public Builder expenseId(long val) {
            expenseId = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder transaction(Transaction val) {
            transaction = val;
            return this;
        }

        public Builder expenseInfo(ExpenseInfo val) {
            expenseInfo = val;
            return this;
        }

        public Expense build() {
            return new Expense(this);
        }
    }
}
