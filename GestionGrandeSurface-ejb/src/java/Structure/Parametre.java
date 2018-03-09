/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

import EntityBean.Employe;
import EntityBean.Role;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Nawar
 */
public class Parametre {
    public String nom = "";
    public String type ;
    public Object valeur = "";
    
    public Parametre(String nom, String type, Object valeur){
        this.nom    = nom;
        this.type   = type;
        this.valeur = valeur;
    } 
    
  
}
