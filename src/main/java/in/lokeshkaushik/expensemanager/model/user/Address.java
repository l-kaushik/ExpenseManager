package in.lokeshkaushik.expensemanager.model.user;

import in.lokeshkaushik.expensemanager.model.base.BaseEntity;
import in.lokeshkaushik.expensemanager.model.base.Identifiable;
import jakarta.persistence.*;

@Entity
public class Address extends BaseEntity implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;

    @ManyToOne
    @JoinColumn(name="user_info_id", nullable = false)
    private UserInfo userInfo;

    private String street;
    private String city;
    private String state;
    private String zipCode;

    // Constructors
    protected Address(){}

    private Address(Builder builder) {
        setAddressId(builder.addressId);
        setUserInfo(builder.userInfo);
        setStreet(builder.street);
        setCity(builder.city);
        setState(builder.state);
        setZipCode(builder.zipCode);
    }

    // getters and setters

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public Long getId() {
        return addressId;
    }

    // Builder

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private long addressId;
        private UserInfo userInfo;
        private String street;
        private String city;
        private String state;
        private String zipCode;

        private Builder() {
        }

        public Builder addressId(long val) {
            addressId = val;
            return this;
        }

        public Builder userInfo(UserInfo val) {
            userInfo = val;
            return this;
        }

        public Builder street(String val) {
            street = val;
            return this;
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public Builder state(String val) {
            state = val;
            return this;
        }

        public Builder zipCode(String val) {
            zipCode = val;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

}
