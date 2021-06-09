/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import InterfaceClass.ServerInterface;
import Model.Account;
import config.config;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import utils.encription;

/**
 *
 * @author Nishimwe Elysee
 */
public class Clients extends javax.swing.JFrame{

    encription encr =  new encription();
    static String usernames;
    static Socket socket = null;
    static String receiver;
    private static  ObjectInputStream oin;
    private static  ObjectOutputStream oout;
    config con = new config();
    /**
     * Creates new form Clients 
     * @param fname
     * @param usname
     * @param p
     * @throws java.io.IOException
     */

    public Clients(String fname, String usname, byte[] p) throws IOException {
        initComponents();
        socket = new Socket(con.getSERVER_IP(), con.getSOCKETPORT());
        ServerConnection serverConn = new ServerConnection(socket);
        oout =new ObjectOutputStream(socket.getOutputStream());
        new Thread(serverConn).start();
        DefaultListModel list = new DefaultListModel();
            list.addElement("name");
            list.addElement(usname);
        oout.writeObject(list);
        usernames = usname;
        fullname.setText(fname);
        username.setText(""+usname);
        ImageIcon img = new ImageIcon(p);
        Image image = img.getImage().getScaledInstance(photo.getWidth(), photo.getHeight(), Image.SCALE_DEFAULT);
        photo.setIcon(new ImageIcon(image));
        getUsers();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        photo = new javax.swing.JLabel();
        fullname = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        photo1 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        msg_txt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        scrpane = new javax.swing.JScrollPane();
        pnlchat = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_list = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 0));

        jPanel1.setBackground(new java.awt.Color(153, 153, 0));

        jPanel2.setBackground(new java.awt.Color(153, 153, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "user Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 0, 51))); // NOI18N

        photo.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logout.png"))); // NOI18N
        jLabel1.setText("Log out");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(photo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fullname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel3.setBackground(java.awt.Color.darkGray);
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jPanel5.setBackground(java.awt.Color.darkGray);

        photo1.setAlignmentX(10.0F);
        photo1.setAlignmentY(10.0F);
        photo1.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photo1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(photo1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(java.awt.Color.gray);

        msg_txt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        msg_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                msg_txtKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-attach-64.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-sent-64.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(msg_txt)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(msg_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlchat.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout pnlchatLayout = new javax.swing.GroupLayout(pnlchat);
        pnlchat.setLayout(pnlchatLayout);
        pnlchatLayout.setHorizontalGroup(
            pnlchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );
        pnlchatLayout.setVerticalGroup(
            pnlchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );

        scrpane.setViewportView(pnlchat);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrpane))))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrpane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 0));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(153, 153, 0));

        user_list.setBackground(new java.awt.Color(0, 0, 102));
        user_list.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        user_list.setForeground(new java.awt.Color(0, 153, 153));
        user_list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                user_listValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(user_list);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Chats", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void user_listValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_user_listValueChanged
       try { 
           String x = user_list.getSelectedValue();
            Registry registry = LocateRegistry.getRegistry(con.getSERVER_IP(),con.getRMIPORT());
            ServerInterface adao = (ServerInterface) registry.lookup("ServerAccount");
            List<Account> accounts = adao.findByUsername(x);
            for(Account s:accounts){
                name.setText(s.getFullname());
                receiver = s.getUsername();
                photo1.setIcon(new ImageIcon(new ImageIcon(changeImage(s.getPhoto())).getImage().getScaledInstance(photo1.getWidth(), photo1.getHeight(), Image.SCALE_DEFAULT)));
            }
            pnlchat.removeAll();
            pnlchat.setPreferredSize(new Dimension(360, 300));
            pnlchat.revalidate();
            pnlchat.repaint();
            heightOfPanel = 0;
            hellman h = new hellman(usernames, receiver);
            h.show();
        } catch (IOException | NotBoundException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_user_listValueChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            DefaultListModel list = new DefaultListModel();
            list.addElement("to");
            
            list.addElement(encr.encrypt(msg_txt.getText(), usernames));
            list.addElement(receiver);
            
            oout.writeObject(list);
            CreateBoxMessage(msg_txt.getText(),true);
            msg_txt.setText("");
            scrpane.getVerticalScrollBar().setValue(scrpane.getVerticalScrollBar().getMaximum()+3);
        } catch (IOException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try {
            DefaultListModel list = new DefaultListModel();
            list.addElement("logout");
            list.addElement(usernames);
            oout.writeObject(list);
            login l = new login();
            l.show();
            this.hide();
        } catch (IOException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void msg_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_msg_txtKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                DefaultListModel list = new DefaultListModel();
                list.addElement("to");
                list.addElement(encr.encrypt(msg_txt.getText(), usernames));
                list.addElement(receiver);
                
                oout.writeObject(list);
                oout.flush();
                CreateBoxMessage(msg_txt.getText(),true);
                scrpane.getVerticalScrollBar().setValue(scrpane.getVerticalScrollBar().getMaximum()+3);
                msg_txt.setText("");
            } catch (IOException ex) {
                Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_msg_txtKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Choose a File");
        if(fc.showOpenDialog(this)== JFileChooser.APPROVE_OPTION){
            try {
                File file =  fc.getSelectedFile();
                byte[] buffer = getByteFile(file);
                DefaultListModel list = new DefaultListModel();
                list.addElement("file");
                list.addElement(receiver);
                list.addElement(file.getName());
                list.addElement(buffer);
                oout.writeObject(list);
                CreateBoxSendFile(file.getName(), true);
            } catch (IOException ex) {
                Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Clients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Clients("","",null).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
            }
        });
        
        
                 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fullname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private static javax.swing.JTextField msg_txt;
    private static javax.swing.JLabel name;
    private javax.swing.JLabel photo;
    private static javax.swing.JLabel photo1;
    private static javax.swing.JPanel pnlchat;
    private javax.swing.JScrollPane scrpane;
    private static javax.swing.JList<String> user_list;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
    private void getUsers(){
        
        try {
            Registry registry = LocateRegistry.getRegistry(con.getSERVER_IP(),con.getRMIPORT());
            ServerInterface adao = (ServerInterface) registry.lookup("ServerAccount");
            ArrayList array = adao.displayUsers();
            
            String[] users= new String[array.size()];
            int  j=0;
            for(int i = 0;i<array.size();i++){
                if(!array.get(i).equals(usernames)){
                    users[j] = array.get(i).toString();
                    j++;
                }
            }
            user_list.setListData(users);
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void printMesage(String msg){
        System.out.println("Server say: "+ msg);
        encription encr = new encription();
        msg = encr.dencrypt(msg, usernames);
        CreateBoxMessage(msg,false);
        msg_txt.setText("");
    }
    private static int heightOfPanel= 0;
    public static  void CreateBoxMessage(String message, Boolean isRight){
        if(heightOfPanel + 100 > pnlchat.getSize().height){
            pnlchat.setPreferredSize(new Dimension(pnlchat.getSize().width, heightOfPanel+100));
        }
        JPanel panel= new JPanel();
        JLabel text = new JLabel(message);
        Font font = new Font("Serge UI Semilight", Font.PLAIN, 14);
        text.setFont(font);
        panel.add(text, CENTER_ALIGNMENT);
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        int textWidth = (int) (font.getStringBounds(message, frc).getWidth());
        int textHeight = (int) (font.getStringBounds(message, frc).getHeight());
        
        int widthPanel = textWidth + 20;
        int heightPanel = textHeight + 20;
        panel.setSize(widthPanel, heightPanel);
        
        int x = 0;
        
        if(isRight){
            x = pnlchat.getSize().width - widthPanel- 80;
        }
        else{
            x = 50;
        }
        heightOfPanel+= 20;
        panel.setLocation(x, heightOfPanel);
        heightOfPanel +=heightPanel;
        if(isRight){
            panel.setBackground(new Color(159,255,169));   
        }else
        {
             panel.setBackground(new Color(200,200,200));
        }
        pnlchat.add(panel);
        pnlchat.revalidate();
        pnlchat.repaint();
    }
    public static BufferedImage changeImage(byte[] path) throws IOException{
        ByteArrayInputStream byt = new ByteArrayInputStream(path);
        BufferedImage image = ImageIO.read(byt);
        Area clip = new Area( new Rectangle(0, 0, image.getWidth(), image.getHeight()) );
        Area oval = new Area( new Ellipse2D.Double(0, 0, image.getWidth() - 1, image.getHeight() - 1) );
        clip.subtract( oval );
        Graphics g2d = image.createGraphics();
        g2d.setClip( clip );
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(0, 0, image.getWidth(), image.getHeight());
        return image;
    }

    public static byte[] getByteFile(File file) {
        
        try {
            byte[] buffer = new byte[(int) file.length()];
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            in.readFully(buffer);
            return buffer;
        
        } catch (IOException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public static void CreateBoxSendFile(String filename, boolean isRight){
        if(heightOfPanel + 200 > pnlchat.getSize().height){
            pnlchat.setPreferredSize(new Dimension(pnlchat.getSize().width, heightOfPanel + 200));
        }
        JPanel panel = new JPanel();
        JLabel text = new JLabel(filename);
        JLabel lbIconFile = new JLabel();
        lbIconFile.setSize(48, 48);
        if(isRight){
            lbIconFile.setIcon(new ImageIcon("C:/Users/Nishimwe Elysee/Documents/NetBeansProjects/Chat/src/Icons/icons8-file-48.png"));
        }
        else
        {
            lbIconFile.setIcon(new ImageIcon("C:/Users/Nishimwe Elysee/Documents/NetBeansProjects/Chat/src/Icons/icons8-file-64.png"));
        }
        panel.add(lbIconFile);
        Font font = new Font("Seque UI Semilight", Font.PLAIN, 14);
        text.setFont(font);
        panel.add(text, CENTER_ALIGNMENT);
        
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        int textWidth = (int) (font.getStringBounds(filename, frc).getWidth());
        int textHeight = (int) (font.getStringBounds(filename, frc).getHeight());
        
        int widthPanel = textWidth+ 60;
        int heightPanel = textHeight + 35;
        panel.setSize(widthPanel,heightPanel);
        int x = 0;
        if(isRight){
            x = pnlchat.getSize().width - widthPanel - 60;
        }
        else{
            x = 50;
        }
        heightOfPanel += 20;
        panel.setLocation(x, heightOfPanel);
        heightOfPanel += heightPanel;
        
        if(isRight){
            panel.setBackground(new Color(159, 255, 169));
        }
        else
        {
            panel.setBackground(new Color(200, 200, 200));
        }
        
        pnlchat.add(panel);
        pnlchat.revalidate();
        pnlchat.repaint();
        
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                GetFileFromServer(filename);
            }
            @Override
            public void mouseEntered(MouseEvent e){
                panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            
        });
    }
    private static void GetFileFromServer(String filename) {

        try {
            DefaultListModel list = new DefaultListModel();
            list.addElement("getFile");
            list.addElement(filename);
            list.addElement(usernames);
            oout.writeObject(list);
        } catch (IOException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static void downloadFile(byte[] cont,String filename) {
        try {
            JFileChooser file = new JFileChooser();
            file.setDialogTitle("Save as ");
            file.setSelectedFile(new File(filename));
            if(file.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                
                File savefile = file.getSelectedFile();
                String path = savefile.getAbsolutePath();
                FileOutputStream fileout;
                fileout = new FileOutputStream(path);
                fileout.write(cont);
                fileout.flush();
                fileout.close();
                JOptionPane.showMessageDialog(null, "File saved. ");

            }
            
        } catch (IOException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
