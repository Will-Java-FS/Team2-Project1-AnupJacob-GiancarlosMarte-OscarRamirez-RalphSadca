package com.revature.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name="User_Address")
public class User_Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_address_id")
    private int user_address_id;
    @Column
    private String address_line1;
    @Column
    private String address_line2;
    @Column
    private String city;
    @Column
    private String postal_code;
    @Column
    private String country;
    @Column(length = 11)
    private String telephone;
    @Column(length = 11)
    private String mobile;
    @OneToOne
    @JoinColumn(name ="user_id")
    private User user;

    public User_Address(int user_address_id, String address_line1, String address_line2, String city, String postal_code, String country, String telephone, String mobile, User user) {
        this.user_address_id = user_address_id;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
        this.telephone = telephone;
        this.mobile = mobile;
        this.user = user;
    }

    public int getUser_address_id() {
        return user_address_id;
    }

    public void setUser_address_id(int user_address_id) {
        this.user_address_id = user_address_id;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User_Address that = (User_Address) o;
        return getUser_address_id() == that.getUser_address_id() && Objects.equals(getAddress_line1(), that.getAddress_line1()) && Objects.equals(getAddress_line2(), that.getAddress_line2()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getPostal_code(), that.getPostal_code()) && Objects.equals(getCountry(), that.getCountry()) && Objects.equals(getTelephone(), that.getTelephone()) && Objects.equals(getMobile(), that.getMobile()) && Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_address_id(), getAddress_line1(), getAddress_line2(), getCity(), getPostal_code(), getCountry(), getTelephone(), getMobile(), getUser());
    }

    @Override
    public String toString() {
        return "User_Address{" +
                "user_address_id=" + user_address_id +
                ", address_line1='" + address_line1 + '\'' +
                ", address_line2='" + address_line2 + '\'' +
                ", city='" + city + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", country='" + country + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", user=" + user +
                '}';
    }
}
