package in.lokeshkaushik.expensemanager.model.account;

import in.lokeshkaushik.expensemanager.model.expense.Expense;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;

    @ManyToOne
    @JoinColumn(name = "sender_account_id")
    private Account senderAccount;

    @ManyToOne
    @JoinColumn(name = "receiver_account_id")
    private Account receiverAccount;

    @OneToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;

    private TransactionType transactionType;
    private PaymentStatus paymentStatus;
    private PaymentMethod paymentMethod;
    private LocalDateTime timestamp;
    private String remark;
    private BigDecimal amount;

    // Constructors

    protected Transaction() {}

    private Transaction(Builder builder) {
        setTransactionId(builder.transactionId);
        setSenderAccount(builder.senderAccount);
        setReceiverAccount(builder.receiverAccount);
        setExpense(builder.expense);
        setTransactionType(builder.transactionType);
        setPaymentStatus(builder.paymentStatus);
        setPaymentMethod(builder.paymentMethod);
        setTimestamp(builder.timestamp);
        setRemark(builder.remark);
        setAmount(builder.amount);
    }

    // Getters and Setters

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    // Builder

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private long transactionId;
        private Account senderAccount;
        private Account receiverAccount;
        private Expense expense;
        private TransactionType transactionType;
        private PaymentStatus paymentStatus;
        private PaymentMethod paymentMethod;
        private LocalDateTime timestamp;
        private String remark;
        private BigDecimal amount;

        private Builder() {
        }

        public Builder transactionId(long val) {
            transactionId = val;
            return this;
        }

        public Builder senderAccount(Account val) {
            senderAccount = val;
            return this;
        }

        public Builder receiverAccount(Account val) {
            receiverAccount = val;
            return this;
        }

        public Builder expense(Expense val) {
            expense = val;
            return this;
        }

        public Builder transactionType(TransactionType val) {
            transactionType = val;
            return this;
        }

        public Builder paymentStatus(PaymentStatus val) {
            paymentStatus = val;
            return this;
        }

        public Builder paymentMethod(PaymentMethod val) {
            paymentMethod = val;
            return this;
        }

        public Builder timestamp(LocalDateTime val) {
            timestamp = val;
            return this;
        }

        public Builder remark(String val) {
            remark = val;
            return this;
        }

        public Builder amount(BigDecimal val) {
            amount = val;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}
