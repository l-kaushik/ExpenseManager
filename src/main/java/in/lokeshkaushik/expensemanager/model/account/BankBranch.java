package in.lokeshkaushik.expensemanager.model.account;

import in.lokeshkaushik.expensemanager.model.base.Identifiable;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class BankBranch implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long branchId;

    @OneToMany(mappedBy = "bankBranch")
    List<Account> accounts;

    private String IFSCCode;
    private String branchCode;
    private String branchName;

    // Constructors

    protected BankBranch() {}

    private BankBranch(Builder builder) {
        setBranchId(builder.branchId);
        setAccounts(builder.accounts);
        setIFSCCode(builder.IFSCCode);
        setBranchCode(builder.branchCode);
        setBranchName(builder.branchName);
    }

    // can add Address field for this branch, but I don't think there is need for it right now

    // Getters and Setters

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public Long getId() {
        return branchId;
    }

    // Builder

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private long branchId;
        private List<Account> accounts;
        private String IFSCCode;
        private String branchCode;
        private String branchName;

        private Builder() {
        }

        public Builder branchId(long val) {
            branchId = val;
            return this;
        }

        public Builder accounts(List<Account> val) {
            accounts = val;
            return this;
        }

        public Builder IFSCCode(String val) {
            IFSCCode = val;
            return this;
        }

        public Builder branchCode(String val) {
            branchCode = val;
            return this;
        }

        public Builder branchName(String val) {
            branchName = val;
            return this;
        }

        public BankBranch build() {
            return new BankBranch(this);
        }
    }
}
