/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.ArticleMagasin;
import EntityBean.Lot;
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
    public void creerLot(Date date_de_peremption, int quantite, ArticleMagasin article) {
        Lot l = new Lot();
        l.setDate_promption(date_de_peremption);
        l.setQuantite_de_lot(quantite);
        l.setArticleMagasin(article);
        em.persist(l);
    }
    
     @Override
    public List<Lot> getLots(String query, ArrayList<Parametre> params) throws Exception{
        List<Lot> lots = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            lots = q.getResultList();
        }catch(Exception exe){throw exe;}
        return lots;
    }

    @Override
    public void ajouterQuantiteLot(Lot lot, int quantite) {
        lot.setQuantite_de_lot(lot.getQuantite_de_lot()+quantite);
        em.merge(lot);
    }
    
    @Override
    public void enleverQuantiteLot(Lot lot, int quantite) {
        lot.setQuantite_de_lot(lot.getQuantite_de_lot()-quantite);
        em.merge(lot);
    }
    
    
    
    
}
