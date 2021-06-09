/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Nishimwe Elysee
 */
public class ClientHandler implements Runnable{
    private Socket client;
    private ObjectInputStream oin;
    private ObjectOutputStream oout;
    private ArrayList<ClientHandler> clients;
    static ArrayList names = new ArrayList();
    public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients){
        this.client = clientSocket;
        this.clients = clients;
    }
    @Override
    public void run() {
            try{
                oin = new ObjectInputStream(client.getInputStream());
                oout = new ObjectOutputStream(client.getOutputStream());
                while(true){
                    if(oin==null) break;
                    DefaultListModel list = (DefaultListModel) oin.readObject();
                    
                    String msgtype = (String) list.getElementAt(0);
                    System.out.println("Mesage type "+msgtype);
                    if(msgtype.equals("name"))
                    {
                        String username = (String) list.getElementAt(1);
                        if(!findUser(username))
                           names.add(username);
                    }else if(msgtype.equals("All")){
                        String msg = (String) list.getElementAt(1);
                            outToAll(msg);
                    }
                    else if(msgtype.equals("to")){
                        String msg = (String) list.getElementAt(1);
                        String receiver = (String) list.getElementAt(2);
                        outToOne(msg,receiver);
                    }else if(msgtype.equals("file")){
                        System.out.println(list);
                        String receiver = (String) list.getElementAt(1);
                        String filename = (String) list.getElementAt(2);
                        byte[] buffer = (byte[]) list.getElementAt(3);
                        FileOutputStream fileout;
                        fileout = new FileOutputStream(filename);
                        fileout.write(buffer);
                        fileout.close();
                        sendFile(filename,receiver);
                    }
                    else if(msgtype.equals("getFile")){
                        String filename = (String) list.getElementAt(1);
                        String username = (String) list.getElementAt(2);
                        byte[] contentFile = getByteFile(new File(filename));
                        DownloadFile(contentFile,username,filename);
                    }
                    else if(msgtype.equals("logout")){
                        String username = (String) list.getElementAt(1);
                        removeUser(username, this);
                    }
                }
            }catch(IOException | ClassNotFoundException ex){
                
            }finally{
                try {
                    oin.close();
                    oout.close();
                    client.close();
                } catch (IOException ex) {
                    Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    void removeUser(String userName, ClientHandler aUser) throws IOException {
        boolean removed = names.remove(userName);
            if (removed) {
            clients.remove(aUser);
            System.out.println("The user " + userName + " quitted");
            client.close();
        }
     }
    
    private boolean findUser(String name){
        boolean yes=false;
        for(Object c:names){
            if(c==name){
                yes = true;
            }
        }
        return yes;
    }
    private void outToAll(String msg) throws IOException {
        DefaultListModel model = new DefaultListModel();
        model.addElement(msg);
        for(ClientHandler aClient:clients){
            aClient.oout.writeObject(model);
        }
    }
    private void outToOne(String msg, String name) throws IOException {
        int j=0;
        DefaultListModel model = new DefaultListModel();
        model.addElement(msg);
        for(ClientHandler aClient:clients){
            if(names.get(j).equals(name)){
                j=0;
                aClient.oout.writeObject(model);
                break;
            }
            else
            {
                j++;
            }
        }
    }
    private void sendFile(String filename,String receiver) throws IOException{
         int j=0;    
         DefaultListModel model = new DefaultListModel();
         model.addElement("file");
         model.addElement(filename);
        for(ClientHandler aClient:clients){
            if(names.get(j).equals(receiver)){
                j=0;
                aClient.oout.writeObject(model);
                break;
            }
            else
            {
                j++;
            }
        }
    }
    private byte[] getByteFile(File file) {
        
        try {
            byte[] buffer = new byte[(int) file.length()];
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            in.readFully(buffer);
            return buffer;
        
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    private void DownloadFile(byte[] contentFile,String username,String filename) throws IOException {
         int j=0;
         DefaultListModel model = new DefaultListModel();
         model.addElement("download");
         model.addElement(contentFile);
         model.addElement(filename);
        for(ClientHandler aClient:clients){
            if(names.get(j).equals(username)){
                j=0;
                aClient.oout.writeObject(model);
                break;
            }
            else
            {
                j++;
            }
        }
    }
}