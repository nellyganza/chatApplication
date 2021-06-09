/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import InterfaceClass.ServerInterface;
import Model.Account;
import Utils.HibernateUtil;
import config.config;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nishimwe Elysee
 */
public class ServerClass extends UnicastRemoteObject implements ServerInterface{
    static ServerSocket ss = null;
    static Socket s1 = null;
    static config con = new config();
    
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);
    public ServerClass() throws RemoteException {
        super();
    }
    public static void main(String[] args) throws RemoteException, IOException{
        try {
            Registry reg = LocateRegistry.createRegistry(con.RMIPORT);
            reg.rebind("ServerAccount",new ServerClass());
        } catch (AccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        ss = new ServerSocket(con.SOCKETPORT);
             while(true){
                System.out.println("Server waiting for client to connect ...............");
                s1 = ss.accept();
                System.out.println("Server Connected ...............");
                 ClientHandler clientThread = new ClientHandler(s1, clients);
                 if(!findThread(clientThread)){
                    clients.add(clientThread);
                    pool.execute(clientThread);
                 }
             }
    }
    private static boolean findThread(ClientHandler thread){
        boolean yes=false;
        for(ClientHandler c:clients){
            if(c==thread){
                yes = true;
            }
        }
        return yes;
    }
    Session session = null;
    @Override
    public void createAccount(Account acc){
        System.out.println(acc.getFullname()+acc.getEmailAddress()+acc.getUsername());
        try{
        session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(acc);
            tx.commit();
            session.close();
        }catch(HibernateException ex){
            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    @Override
    public void updateAccount(Account acc){
        try{
        session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
                session.update(acc);
            tx.commit();
            session.close();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    @Override
     public void changePassword(String  username,String newpass){
        try{
        session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
                session.createQuery("update User set password = '"+newpass+"' where username = '"+username+"'").executeUpdate();
            tx.commit();
            session.close();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    @Override
    public void deleteAccount(Account acc){
        try{
        session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(acc);
            tx.commit();
            session.close();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    @Override
    public ArrayList displayUsers(){
        ArrayList accounts =null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            accounts = (ArrayList) session.createCriteria(Account.class).setProjection(Projections.property("username")).list();
            tx.commit();
            session.close();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return accounts;
    }
    @Override
    public List<Account> findByEmail(String email){
        List<Account> accounts =null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            accounts = session.createCriteria(Account.class).add(Restrictions.eq("email", email)).list();
            tx.commit();
            session.close();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return accounts;
    }
    @Override
    public List<Account> findByUsername(String username){
        List<Account>  accounts = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            accounts = session.createCriteria(Account.class).add(Restrictions.eq("username", username)).list();
            tx.commit();
         
            session.close();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return accounts;
    }
    @Override
    public List<Account> findByPhoneNumber(String phonenumber){
        List<Account> accounts =null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            accounts =  session.createCriteria(Account.class).add(Restrictions.eq("phonenumber", phonenumber)).list();
            tx.commit();
            session.close();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return accounts;
    }
}
