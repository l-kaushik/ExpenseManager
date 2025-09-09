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
    private FullName fullNameId;

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    private Date brithDate;

    public long getUserInfoId() {
        return userInfoId;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setUserInfoId(long userInfoId) {
        this.userInfoId = userInfoId;
    }

    public FullName getFullNameId() {
        return fullNameId;
    }

    public void setFullNameId(FullName fullNameId) {
        this.fullNameId = fullNameId;
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
}
