/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

import EntityBean.Employe;
import EntityBean.Role;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Nawar
 */
public abstract class Aide {
    
     public static void Casting(String type,Object o) throws ExecutionException{
      try {
       switch(type){
           case "int":
               o = (int)o;
               break;
           case "String":
                o = (String)o;
               break;
           case "Role":
                o = (Role)o;
               break;
               
           case "Employe":
                o = (Employe)o;
               break;
       }
      }catch(Exception exe){ throw  exe;}
   }
     
     public static Object getObjectDeListe(Object [] liste){
         Object o = null;
         for ( Object element : liste){
             o = element;
         }
         return o;
     }
     
     
     public static String GenererLogin(String nom,String prenom){
           return nom+"."+prenom.charAt(0);
     }
     
     public static String GenererMDP(){
         String str="";
         Random rand = new Random();
            for(int i = 0 ; i < 10 ; i++){
              char c = (char)(rand.nextInt(26) + 97);
              str += c;
            }
            return str;
     }
     
     public static String encrypterMdp(String mdp) throws DigestException, NoSuchAlgorithmException{
          MessageDigest md = MessageDigest.getInstance("MD5");

        try {
            md.update(mdp.getBytes());
            MessageDigest tc1 = (MessageDigest) md.clone();
            byte[] toChapter1Digest = tc1.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < toChapter1Digest.length; i++) {
                if ((0xff & toChapter1Digest[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & toChapter1Digest[i])));
                }
                else {
                    hexString.append(Integer.toHexString(0xFF & toChapter1Digest[i]));
                }
            }
            return hexString.toString();
        }   catch (CloneNotSupportedException cnse) {
            throw new DigestException("couldn't make digest of partial content");
        }
     }
    
}
