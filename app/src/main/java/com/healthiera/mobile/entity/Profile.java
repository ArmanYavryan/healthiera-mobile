package com.healthiera.mobile.entity;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.Model;

/**
 * Created by Davit on 05.08.2016.
 */
@Table(name = "profile")
public class Profile extends Model {
    public Profile(String birthday, String email, String image, String lastName, String name, String password, Boolean sex, String userName, String zipCode) {
        super();
        this.birthday = birthday;
        this.email = email;
        this.image = image;
        this.lastName = lastName;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.userName = userName;
        this.zipCode = zipCode;
    }

    public Profile() {
        super();
    }
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "sex")
    private Boolean sex;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "email")
    private String email;
    @Column(name = "image")
    private String image;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
