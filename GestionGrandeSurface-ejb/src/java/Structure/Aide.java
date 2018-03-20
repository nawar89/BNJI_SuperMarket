/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

import EntityBean.Article;
import EntityBean.ArticleMagasin;
import EntityBean.BonCommande;
import EntityBean.Categorie;
import EntityBean.Employe;
import EntityBean.Etat_Livraison;
import EntityBean.Fournisseur;
import EntityBean.LigneCommande;
import EntityBean.Lot;
import EntityBean.Role;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
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
            case "Categorie":
                o = (Categorie)o;
               break;
            case "Etat_Livraison":
                 o =(Etat_Livraison)o;
                 break;
            case "Article":
                 o =(Article)o;
                 break; 
                 
            case "Lot":
                 o =(Lot)o;
                 break; 
            case "ArticleMagasin":
                 o =(ArticleMagasin)o;
                 break; 
                 
             case "Date":
                 o =(Date)o;
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
     public static List<String> rolesToTitles (List<Role> listRoles)
     {
        List<String> listeTitres = null;
        listeTitres = new ArrayList<String>();
         for (Role role : listRoles)
         {
             switch(role.getNom()){
                 case "DirNat" : listeTitres.add("Direction Nationale");
                 break;
                 case "DirMag" : listeTitres.add("Directeur Magasin");
                 break;
                 case "AgRayon" :listeTitres.add("Agent de Rayon");
                 break;
                 case "ChefRayon": listeTitres.add("Chef de Rayon");
                 break;
                 case "AgLivraison": listeTitres.add("Agent de Livraison");
                 break;
                 case "AgCaisse" : listeTitres.add("Agent de Caisse");
                 break;
                 default : listeTitres.add("inconnu");
                 break;
             }
             
         }
         if (listeTitres.isEmpty())
         {
             
         }
         return listeTitres ;
     }
     public static String aTitletoRoleName (String title)
     {
         String nomRole = null;
         switch (title)
         {
             case "Direction Nationale" : nomRole = "DirNat";
             break;
             case "Directeur Magasin" : nomRole ="DirMag"; 
             break;
             case "Agent de Rayon":  nomRole = "AgRayon" ;
             break;
             case "Chef de Rayon": nomRole = "ChefRayon" ;
             break;
             case  "Agent de Livraison": nomRole = "AgLivraison";
             break;
             case  "Agent de Caisse": nomRole = "AgCaisse";
             break;
             default : nomRole = "inconnu";
             break;
         }
         return nomRole; 
     }
     
     
    
}
