/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Account;
import Server.ServerClass;
import config.config;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nishimwe Elysee
 */
public class encriiption{
   config con = new config();
    Session session=null;
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
    public  String encrypt(String message,String username){
          
            BigInteger sharedsecretkey2  = new BigInteger(findByUsername(username).get(0).getClickPublicKey());
            String Newstr=" ";
            BigInteger n;
            try {
                for (int i=0;i<message.length();i++)
                {
                    char ch=Character.toLowerCase(message.charAt(i));
                    switch (ch)
                    {
                        case 'a':
                            n = BigInteger.valueOf(1);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'b':
                            n = BigInteger.valueOf(2);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'c':
                            n = BigInteger.valueOf(3);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'd':
                            n = BigInteger.valueOf(4);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'e':
                            n = BigInteger.valueOf(5);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'f':
                            n = BigInteger.valueOf(6);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'g':
                            n =  BigInteger.valueOf(7);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'h':
                            n = BigInteger.valueOf(8);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'i':
                            n = BigInteger.valueOf(9);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'j':
                            n = BigInteger.valueOf(10);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'k':
                            n = BigInteger.valueOf(11);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'l':
                            n = BigInteger.valueOf(12);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'm':
                            n = BigInteger.valueOf(13);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'n':
                            n = BigInteger.valueOf(14);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'o':
                            n = BigInteger.valueOf(15);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'p':
                            n = BigInteger.valueOf(16);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'q':
                            n = BigInteger.valueOf(17);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'r':
                            n = BigInteger.valueOf(18);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 's':
                            n = BigInteger.valueOf(19);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 't':
                            n = BigInteger.valueOf(20);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'u':
                            n = BigInteger.valueOf(21);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'v':
                            n = BigInteger.valueOf(22);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'w':
                            n = BigInteger.valueOf(23);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'x':
                            n = BigInteger.valueOf(24);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'y':
                            n = BigInteger.valueOf(25);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case 'z':
                            n = BigInteger.valueOf(26);
                            n = (n.multiply(sharedsecretkey2));
                            Newstr=Newstr+n+"-";
                            break;
                        case ' ': Newstr=Newstr+"$";
                        break;
                        
                        default: Newstr=Newstr+"&";  
                    }
                }
            }
            catch(Exception ioe)
            {
            }
            System.out.println("encrypted no vowels: "+Newstr);
            String cipherText = Newstr.replace("1","A").replace("2", "B").replace("3","C").replace("4","D").replace("5","F").replace("6","G").replace("7","H").replace("8","I").replace("9","J");
            return cipherText;
      
    
    }
    
    public  String dencrypt(String message,String username){
    
           int position;
           BigInteger n,d,diff,tot;
           String Newstr = "-";
           String cipherText = message.replace("A","1").replace("B","2").replace("C","3").replace("D","4").replace("F","5").replace("G","6").replace("H","7").replace("I","8").replace("J","9");
           System.out.println("removed vowels" + cipherText);
           String str[] = cipherText.split("-");
           System.out.println(Arrays.toString(str));
           String alpha[] = {"-","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
           diff  = BigInteger.valueOf(7);
           tot  = BigInteger.valueOf(23);
           
           
           BigInteger sharedsecretkey2 = new BigInteger(findByUsername(username).get(0).getClickPublicKey());
           
           
           for (String str1 : str) {
               String str2 = str1.replace(" ", "");
               System.out.println(str2);
               n = new BigInteger(str2);
               d = (n.divide(sharedsecretkey2));
               System.out.println("position: " +d);
               position = d.intValue();
               Newstr = Newstr+alpha[position];
           }  System.out.println(Newstr);
           return Newstr.replace("-","");
       
    }
    
}
