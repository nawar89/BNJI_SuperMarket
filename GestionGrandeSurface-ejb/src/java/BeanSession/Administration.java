/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSession;

import BeanFacade.CategorieFacadeLocal;
import BeanFacade.EmployeFacadeLocal;
import BeanFacade.MagasinFacadeLocal;
import BeanFacade.RoleFacadeLocal;
import BeanFacade.SousCategorieFacadeLocal;
import EntityBean.Categorie;
import EntityBean.Employe;
import EntityBean.Role;
import EntityBean.Magasin;
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
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private SousCategorieFacadeLocal sousCategorieFacade;

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
     public void creerEmployee(String nom, String prenom, String adresse, String telephone, String email, String login, String mdp,Role role, Magasin magasin) {
          employeFacade.creerEmployee(nom, prenom, adresse, telephone, email, login, mdp, role, magasin );
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
    
     @Override
    public void creerSousCategorie(String libelle, Categorie categorie) {
        sousCategorieFacade.creerSousCategorie(libelle, categorie);
    }
    
     @Override
    public void creerMagasin(String adresse, String nom, String code, String ville,String horaireOuverture,String horaireFermeture,String gps) {
        magasinFacade.creerMagasin(adresse, nom, code, ville, horaireOuverture, horaireFermeture, gps);
    }
    
     @Override
    public List<Magasin> getMagasins(String query, ArrayList<Parametre> params) throws Exception{
        return magasinFacade.getMagasins(query, params);
    }
    
    @Override
    public void modifierMagasin(String nom, String adresse, String ville, String code, String horaire_ouver, String horaire_ferm, String gps, Magasin magasin) {
        magasinFacade.modifierMagasin(nom, adresse, ville, code, horaire_ouver, horaire_ferm, gps, magasin);
    }
    
      
}
