package com.example.register_page.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Register {

    @Id
    private String fullname;
    private String email;
    private String password;
    private String confirmpassword;

    // Getters and Setters
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    // Constructor
    public Register(String fullname, String email, String password, String confirmpassword) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    public Register() {
    }
}
