/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import javax.swing.DefaultListModel;

/**
 *
 * @author Nishimwe Elysee
 */
public class ServerConnection implements Runnable{
    private Socket server;
    private ObjectInputStream oin;

    public ServerConnection(Socket server) throws IOException {
        this.server = server;
        
    }
    
    
    @Override
    public void run() {
        
        try {
            oin = new ObjectInputStream(server.getInputStream());
            String serverResponse=null;
                while(true){
               DefaultListModel result = (DefaultListModel) oin.readObject();
                serverResponse = (String) result.getElementAt(0);
                if(serverResponse==null) 
                    break;
                else if(serverResponse.equals("file")){
                    String filename = (String) result.getElementAt(1);
                    Clients.CreateBoxSendFile(filename, false);
                }
                else if(serverResponse.equals("download")){
                    System.out.println(result);
                    byte[] cont= (byte[]) result.getElementAt(1);
                    String filename = (String) result.getElementAt(2);
                    Clients.downloadFile(cont,filename);
                }else
                {
                    Clients.printMesage(serverResponse);
                }
                }
            } catch (IOException| ClassNotFoundException ex) {
                //JOptionPane.showMessageDialog(null, ex,"Error Occuried",JOptionPane.ERROR_MESSAGE);
            }
            
            finally{
                try {
                    oin.close();
                } catch (IOException ex) {
                    //JOptionPane.showMessageDialog(null, ex,"Error Occuried",JOptionPane.ERROR_MESSAGE);
                }
            }
    }
    
}
