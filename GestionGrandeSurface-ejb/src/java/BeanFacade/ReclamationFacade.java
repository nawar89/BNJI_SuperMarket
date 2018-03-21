/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Ligne_livraison;
import EntityBean.Reclamation;
import EntityBean.Type_Reclamation;
import Structure.Aide;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.Date;
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
public class ReclamationFacade extends AbstractFacade<Reclamation> implements ReclamationFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReclamationFacade() {
        super(Reclamation.class);
    }

    @Override
    public void creerReclamation(String rec, Type_Reclamation type, Ligne_livraison ligne,Date dateRec) {
        Reclamation r = new Reclamation();
        r.setReclamation(rec);
        r.setEtat_Reclamation(type);
        r.setLigneLivraison(ligne);
        r.setDate_reclamation(dateRec);
        em.persist(r);
    }
    
    
      @Override
    public List<Reclamation> getReclamations(String query, ArrayList<Parametre> params) throws Exception{
        List<Reclamation> recs = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            recs = q.getResultList();
        }catch(Exception exe){throw exe;}
        return recs;
    }
    
    
    
    
}
