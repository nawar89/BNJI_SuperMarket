/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Lot;
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
 * @author i.silvestre
 */
@Stateless
public class LotFacade extends AbstractFacade<Lot> implements LotFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LotFacade() {
        super(Lot.class);
    }

    @Override
    public void modifierQuantiteLot(int quantite, Lot lot) {
        int nouvelleQte = lot.getQuantite_de_lot() - quantite ; 
        lot.setQuantite_de_lot(nouvelleQte);
        em.merge(lot);
    }
    
     @Override
    public List<Lot> getLot(String query, ArrayList<Parametre> params) throws Exception{
        List<Lot> articles = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            articles = q.getResultList();
        }catch(Exception exe){throw exe;}
        return articles;
    }
    
    
}
