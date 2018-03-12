/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSession;

import BeanFacade.EmployeFacadeLocal;
import EntityBean.Magasin;
import EntityBean.Employe ;
import EntityBean.Role;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author i.silvestre
 */
@Stateless
public class DirecteurMagasin implements DirecteurMagasinLocal {

    @EJB
    private EmployeFacadeLocal employeFacade;
    
    

   // public void creerEmployeMagasin(String nom, String prenom, String adresse, String telephone, String email, String login, String mdp,Role role, ) {
         
    // }


}
