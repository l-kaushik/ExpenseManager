package in.lokeshkaushik.expensemanager.model.user;

import in.lokeshkaushik.expensemanager.model.base.BaseEntity;
import in.lokeshkaushik.expensemanager.model.base.Identifiable;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class UserInfo extends BaseEntity implements Identifiable {
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

    private Date birthDate;

    // Constructors

    protected UserInfo() {}

    private UserInfo(Builder builder) {
        setUserInfoId(builder.userInfoId);
        setUser(builder.user);
        setFullName(builder.fullName);
        setAddresses(builder.addresses);
        setBirthDate(builder.birthDate);
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Long getId() {
        return userInfoId;
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
        private Date birthDate;

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

        public Builder birthDate(Date val) {
            birthDate = val;
            return this;
        }

        public UserInfo build() {
            return new UserInfo(this);
        }
    }
}
