/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Employe;
import EntityBean.Role;
import Structure.Aide;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nawar
 */
@Stateless
public class EmployeFacade extends AbstractFacade<Employe> implements EmployeFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeFacade() {
        super(Employe.class);
    }

    @Override
    public void creerEmployee(String nom, String prenom, String adresse, String telephone, String email, String login, String mdp,Role role) {
        Employe emp = new Employe();
        emp.setNom(nom);
        emp.setPrenom(prenom);
        emp.setAdresse(adresse);
        emp.setTelephone(telephone);
        emp.setEmail(email);
        emp.setLogin(login);
        emp.setMdp(mdp);
        emp.setRole(role);
        em.persist(emp);
    }
    
    @Override
    public List<Employe> getEmploye(String query, ArrayList<Parametre> params) throws Exception{
        List<Employe> employes = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            employes = q.getResultList();
        }catch(Exception exe){throw exe;}
        return employes;
    }
     @Override
    public void employeModifierRole(Employe emp, Role role){
        emp.setRole(role);
        em.merge(emp);
    }
    
}
