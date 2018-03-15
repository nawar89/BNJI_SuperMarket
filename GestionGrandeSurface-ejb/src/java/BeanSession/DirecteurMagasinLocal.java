/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSession;

import EntityBean.Categorie;
import EntityBean.Magasin;
import EntityBean.Role;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author i.silvestre
 */
@Local
public interface DirecteurMagasinLocal {
    public void creerEmployeMagasin(String nom, String prenom, String adresse, String telephone, String email, String login, String mdp, Role role, Magasin magasin, List<Categorie> listeCat )throws  Exception ;    

    
}
