/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author Nishimwe Elysee
 */
@Entity
@Table(name = "Users")
public class Account implements Serializable {
    @Id
    @Column(length = 15,nullable = false,unique = false)
    private String username;
    @Column(length = 15,nullable = false)
    private String password;
    @Column(length = 15,nullable = false,unique = false)
    private String phonenumber;
    @Column(length = 30,nullable = false,unique = false)
    private String emailAddress;
    @Column(length = 50,nullable = false)
    private String fullname;
    @Lob
    private byte[] photo;

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
