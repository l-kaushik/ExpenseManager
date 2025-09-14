package in.lokeshkaushik.expensemanager.model.user;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class UserInfo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userInfoId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private FullName fullName;

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    private Date brithDate;

    // Constructors

    protected UserInfo() {}

    private UserInfo(Builder builder) {
        setUserInfoId(builder.userInfoId);
        setUser(builder.user);
        setFullName(builder.fullName);
        setAddresses(builder.addresses);
        setBrithDate(builder.brithDate);
    }

    public long getUserInfoId() {
        return userInfoId;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setUserInfoId(long userInfoId) {
        this.userInfoId = userInfoId;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Date getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(Date brithDate) {
        this.brithDate = brithDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Builder

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private long userInfoId;
        private User user;
        private FullName fullName;
        private List<Address> addresses;
        private Date brithDate;

        private Builder() {
        }

        public Builder userInfoId(long val) {
            userInfoId = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder fullName(FullName val) {
            this.fullName = val;
            return this;
        }

        public Builder addresses(List<Address> val) {
            addresses = val;
            return this;
        }

        public Builder brithDate(Date val) {
            brithDate = val;
            return this;
        }

        public UserInfo build() {
            return new UserInfo(this);
        }
    }
}
