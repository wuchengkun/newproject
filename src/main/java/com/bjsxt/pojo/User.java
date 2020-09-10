package com.bjsxt.pojo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="t_user" ,uniqueConstraints={@UniqueConstraint(columnNames={"userName"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Integer id;
    @NotBlank
    @Column(name = "name")
    private String name;
    @NotBlank
    @Column(name = "address")
    private String address;
    @NotBlank

    @Column(name = "sex")
    private String sex;
    @NotBlank
    @Email
    @Column(name = "email")
    private String email;
    @NotBlank

    @Column(name = "idcard")
    private String idCard;
    @NotBlank
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @NotBlank
    @Column(name = "nationality")
    private String nationality;
    @NotBlank

    @Column(name = "userName")
    private String userName;
    @NotBlank
    @Column(name = "password")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
