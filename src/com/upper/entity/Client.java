package com.upper.entity;

import java.sql.Date;

public class Client {
    private Long id;
    private String fName;
    private String lName;
    private String phoneNumber;
    private String gender;
    private String address;
    private String email;
    private String password;
    private java.sql.Date startDate;



    public Client(Long id, String fName, String lName, String phoneNumber, String gender, String address, String email, String password){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address=address;
        this.email = email;
        this.password = password;
    }
    public Client(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}

