/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceClass;

import Model.Account;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nishimwe Elysee
 */
public interface ServerInterface extends Remote{
    
    public void createAccount(Account acc) throws RemoteException;
    
    public void updateAccount(Account acc) throws RemoteException;
    
     public void changePassword(String  username,String newpass) throws RemoteException;
    
    public void deleteAccount(Account acc) throws RemoteException;
    
    public ArrayList displayUsers() throws RemoteException;
    
    public List<Account> findByEmail(String email) throws RemoteException;
    
    public List<Account> findByUsername(String username)throws RemoteException;
    
    public List<Account> findByPhoneNumber(String phonenumber) throws RemoteException;
}
