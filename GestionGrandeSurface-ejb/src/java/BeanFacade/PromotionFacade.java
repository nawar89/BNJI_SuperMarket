/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Article;
import EntityBean.Employe;
import EntityBean.Promotion;
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
public class PromotionFacade extends AbstractFacade<Promotion> implements PromotionFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromotionFacade() {
        super(Promotion.class);
    }

    @Override
    public void creerPromotion(Date datedeb, Date dateFin, float prix_promo, Employe dirNat, Article article) {
        Promotion p = new Promotion();
        p.setDate_debut(datedeb);
        p.setDate_fin(dateFin);
        p.setPrix_prmotion(prix_promo);
        p.setDirectionNationale(dirNat);
        p.setArticle(article);
        em.persist(p);
    }
     @Override
    public void modifierPromotion(Date datedeb, Date dateFin, float prix_promo, Employe dirNat, Article article,Promotion p) {
        
        p.setDate_debut(datedeb);
        p.setDate_fin(dateFin);
        p.setPrix_prmotion(prix_promo);
        p.setDirectionNationale(dirNat);
        p.setArticle(article);
        em.merge(p);
    }
    
     @Override
    public List<Promotion> getPromotions(String query, ArrayList<Parametre> params) throws Exception{
        List<Promotion> pros = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            pros = q.getResultList();
        }catch(Exception exe){
            //throw exe;
        }
        return pros;
    }
    
    
}
