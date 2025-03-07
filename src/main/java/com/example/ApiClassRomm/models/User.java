package com.example.ApiClassRomm.models;
import com.example.ApiClassRomm.helpers.UserType;
import jakarta.persistence.Entity;

@Entity
public class User {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private  String number;
    private UserType userType;

    public User() {


    }

    public User(Integer id, String name, String email, String password, String number, UserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.number = number;
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}
