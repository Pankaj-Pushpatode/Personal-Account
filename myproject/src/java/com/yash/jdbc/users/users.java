/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yash.jdbc.users;

/**
 *
 * @author YASH KUMAR
 */
public class users {
    int Uid;


    String Username;
    String Password;
    String Name;
    String Address;
    String Mobile;
    String Email;

    public users() {
    }


     public users(String Username, String Password, String Name, String Address, String Mobile, String Email) {
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
        this.Address = Address;
        this.Mobile = Mobile;
        this.Email = Email;
    }

    public users(int Uid, String Username, String Password, String Name, String Address, String Mobile, String Email) {
        this.Uid = Uid;
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
        this.Address = Address;
        this.Mobile = Mobile;
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int Uid) {
        this.Uid = Uid;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }


}
