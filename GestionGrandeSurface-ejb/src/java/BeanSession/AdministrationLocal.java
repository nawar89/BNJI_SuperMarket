/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSession;

import EntityBean.Categorie;
import EntityBean.Employe;
import EntityBean.Magasin;
import EntityBean.Role;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nawar
 */
@Local
public interface AdministrationLocal {
    List<Employe> getEmploye(String query, ArrayList<Parametre> params) throws Exception;
    void creerEmployee(String nom, String prenom, String adresse, String telephone, String email, String login, String mdp,Role role, Magasin magasin);
    void employeModifierRole(Employe emp, Role role);
    List<Role> getRoles(String query, List<Parametre> params) throws Exception;

    void creerCategorie(String libelle);
    
    List<Categorie> getCategories(String query, ArrayList<Parametre> params) throws Exception;
    
    
}
