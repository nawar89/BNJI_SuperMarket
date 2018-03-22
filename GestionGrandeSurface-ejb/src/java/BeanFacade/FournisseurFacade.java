/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Article;
import EntityBean.Fournisseur;
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
 * @author Jihane
 */
@Stateless
public class FournisseurFacade extends AbstractFacade<Fournisseur> implements FournisseurFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FournisseurFacade() {
        super(Fournisseur.class);
    }

    @Override
    public void creerFournisseur(String nom, String adresse, String telephone, String email,String mdp) throws Exception {
        try {
          Fournisseur fournisseur = new Fournisseur();
          fournisseur.setNom(nom);
          fournisseur.setAdresse(adresse);
          fournisseur.setTelephone(telephone);
          fournisseur.setEmail(email);
          fournisseur.setMdp(mdp);
            em.persist(fournisseur);
        }catch (Exception ex){ throw ex;}
        
    }
    
       //Recherche d'aticle 
    @Override
    public List<Fournisseur> getFournisseur(String query, ArrayList<Parametre> params) throws Exception {
        List<Fournisseur> fors = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            fors = q.getResultList();
        }catch(Exception exe){//throw exe;
            System.err.println("");
        }
        return fors;
    }
    
    
    
    
    
    
}
