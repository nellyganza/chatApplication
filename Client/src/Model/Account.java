/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Nishimwe Elysee
 */
public class Account implements Serializable {
    private String username;
    private String password;
    private String phonenumber;
    private String emailAddress;
    private String fullname;
    private byte[] photo;
    private String clientSecreteKey;
    public String clickPublicKey;

    public Account() {
    }

    public Account(String username) {
        this.username = username;
    }

    public Account(String username, String password, String phonenumber, String emailAddress, String fullname,byte[] photo) {
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.emailAddress = emailAddress;
        this.fullname = fullname;
        this.photo = photo;
    }

    public void setClientSecreteKey(String clientSecreteKey) {
        this.clientSecreteKey = clientSecreteKey;
    }

    public String getClientSecreteKey() {
        return clientSecreteKey;
    }

    public String getClickPublicKey() {
        return clickPublicKey;
    }

    public void setClickPublicKey(String clickPublicKey) {
        this.clickPublicKey = clickPublicKey;
    }

    
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
}
