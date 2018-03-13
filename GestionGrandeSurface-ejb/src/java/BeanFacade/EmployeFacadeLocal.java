/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

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
public interface EmployeFacadeLocal {

    void create(Employe employe);

    void edit(Employe employe);

    void remove(Employe employe);

    Employe find(Object id);

    List<Employe> findAll();

    List<Employe> findRange(int[] range);

    int count();

    void creerEmployee(String nom, String prenom, String adresse, String telephone, String email, String login, String mdp,Role role, Magasin magasin);
    
    List<Employe> getEmploye(String query, ArrayList<Parametre> params) throws Exception;
    
    void employeModifierRole(Employe emp, Role role);
    
}
