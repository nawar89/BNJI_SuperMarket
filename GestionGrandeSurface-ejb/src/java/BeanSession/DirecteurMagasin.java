/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSession;

import BeanFacade.ChefRyon_CategorieFacadeLocal;
import BeanFacade.EmployeFacadeLocal;
import EntityBean.Magasin;
import EntityBean.Employe ;
import EntityBean.Categorie;
import EntityBean.Role;
import Structure.Aide;
import Structure.Parametre;
import Structure.Requete;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author i.silvestre
 */
@Stateless
public class DirecteurMagasin implements DirecteurMagasinLocal {

    @EJB
    private ChefRyon_CategorieFacadeLocal chefRyon_CategorieFacade;

    @EJB
    private EmployeFacadeLocal employeFacade;
    
    
         public List<Employe> getEmploye(String query, ArrayList<Parametre> params) throws Exception{
             return employeFacade.getEmploye(query, params);}

    public void creerEmployeMagasin(String nom, String prenom, String adresse, String telephone, String email, String login, String mdp, Role role, Magasin magasin, List<Categorie> listeCat ) throws  Exception
    {
        employeFacade.creerEmployee(nom, prenom, adresse, telephone, email, login, mdp, role, magasin );
        if (role.getNom().equals("ChefRayon") || role.getNom().equals("AgRayon"))
        {
            try {
                ArrayList<Parametre> mesParam = new ArrayList<>();
                Parametre p = new Parametre("login", "String", login);
                mesParam.add(p);
                p = new Parametre("mdp", "String", mdp);
                mesParam.add(p);
                
                List<Employe> listeEmp = getEmploye(Requete.getEmployes + " AND e.login = :login AND e.mdp = :mdp", mesParam);
                if(!listeEmp.isEmpty() && listeEmp.size()==1)
                {
                    Employe employe = (Employe)Aide.getObjectDeListe(listeEmp.toArray());
                
                    listeCat.forEach((cat) -> {
                        chefRyon_CategorieFacade.creerRelationEmployeRayon(employe, cat);
                    });
                }
                
                
            } catch (Exception ex) {
                throw ex;
            }
            
        }
         
     }


}
