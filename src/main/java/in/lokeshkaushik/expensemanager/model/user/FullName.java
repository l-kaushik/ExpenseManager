package in.lokeshkaushik.expensemanager.model.user;

import jakarta.persistence.*;

@Entity
public class FullName{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fullNameId;

    @OneToOne
    @JoinColumn(name="user_info_id", nullable = false)
    private UserInfo userInfo;

    private String firstName;
    private String middleName;
    private String lastName;

    // Constructor

    protected FullName(){}

    private FullName(Builder builder) {
        setFullNameId(builder.fullNameId);
        setUserInfo(builder.userInfo);
        setFirstName(builder.firstName);
        setMiddleName(builder.middleName);
        setLastName(builder.lastName);
    }

    public long getFullNameId() {
        return fullNameId;
    }

    public void setFullNameId(long fullNameId) {
        this.fullNameId = fullNameId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Builder

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private long fullNameId;
        private UserInfo userInfo;
        private String firstName;
        private String middleName;
        private String lastName;

        private Builder() {
        }

        public Builder fullNameId(long val) {
            fullNameId = val;
            return this;
        }

        public Builder userInfo(UserInfo val) {
            userInfo = val;
            return this;
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder middleName(String val) {
            middleName = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public FullName build() {
            return new FullName(this);
        }
    }
}
