/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author Nishimwe Elysee
 */
public class config {
    public  String SERVER_IP = "localhost";
    public int RMIPORT = 2000;  
    public int SOCKETPORT = 3000;
    public String getSERVER_IP() {
        return SERVER_IP;
    }

    public void setSERVER_IP(String SERVER_IP) {
        this.SERVER_IP = SERVER_IP;
    }

    public int getRMIPORT() {
        return RMIPORT;
    }

    public void setRMIPORT(int RMIPORT) {
        this.RMIPORT = RMIPORT;
    }

    public int getSOCKETPORT() {
        return SOCKETPORT;
    }

    public void setSOCKETPORT(int SOCKETPORT) {
        this.SOCKETPORT = SOCKETPORT;
    }
    
    
}
