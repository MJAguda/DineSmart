package com.example.dinesmart;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class Users {
    private String FullName;
    private String IdNumber;
    private String Password;

    private String Role;





    private int Balance;


    private static Users instance;//Singleton

    public static Users getInstance() {
        if(instance == null){
            instance = new Users();
        }
        return instance;
    }

    //setters
    public void setFullName(String fullName) {
        this.FullName = fullName;
    }
    public void setIdNumber(String IdNumber) {this.IdNumber = IdNumber;}
    public void setPassword(String password) {
        this.Password = password;
    }
    public void setRole(String role) {this.Role = role;}
    public void setBalance(int balance) {Balance = balance;}


    //getters

    public String getFullName() {
        return FullName;
    }

    public String getIdNumber() {
        return IdNumber;
    }

    public String getPassword() {
        return Password;
    }
    public String getRole() {return Role;}
    public int getBalance() {return Balance;}
}

