package in.lokeshkaushik.expensemanager.model.user;

import jakarta.persistence.*;

@Entity
public class FullName{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fullNameId;

    @OneToOne
    @JoinColumn(name="userInfoId")
    private UserInfo userInfo;

    private String firstName;
    private String middleName;
    private String lastName;

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
}
