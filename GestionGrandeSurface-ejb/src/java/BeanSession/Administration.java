/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSession;

import BeanFacade.CategorieFacadeLocal;
import BeanFacade.EmployeFacadeLocal;
import BeanFacade.RoleFacadeLocal;
import EntityBean.Categorie;
import EntityBean.Employe;
import EntityBean.Role;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nawar
 */
@Stateless
public class Administration implements AdministrationLocal {

    @EJB
    private CategorieFacadeLocal categorieFacade;

    @EJB
    private RoleFacadeLocal roleFacade;

    @EJB
    private EmployeFacadeLocal employeFacade;
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @Override
     public List<Employe> getEmploye(String query, ArrayList<Parametre> params) throws Exception{
             return employeFacade.getEmploye(query, params);
     }
      @Override
     public void creerEmployee(String nom, String prenom, String adresse, String telephone, String email, String login, String mdp,Role role) {
          employeFacade.creerEmployee(nom, prenom, adresse, telephone, email, login, mdp, role);
     }
     @Override
     public void employeModifierRole(Employe emp, Role role){
            employeFacade.employeModifierRole(emp, role);
     }
     @Override
      public List<Role> getRoles(String query, List<Parametre> params) throws Exception{
          return roleFacade.getRoles(query, params);
      }

    @Override
    public void creerCategorie(String libelle) {
        categorieFacade.creerCategorie(libelle);
    }
    
    @Override
    public List<Categorie> getCategories(String query, ArrayList<Parametre> params) throws Exception{
        return categorieFacade.getCategories(query, params);
    }
    
      
}
