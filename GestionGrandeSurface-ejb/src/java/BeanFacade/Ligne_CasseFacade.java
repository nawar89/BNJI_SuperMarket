/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.ArticleMagasin;
import EntityBean.Casse;
import EntityBean.Ligne_Casse;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author i.silvestre
 */
@Stateless
public class Ligne_CasseFacade extends AbstractFacade<Ligne_Casse> implements Ligne_CasseFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Ligne_CasseFacade() {
        super(Ligne_Casse.class);
    }

    @Override
    public Ligne_Casse creerLigneCasse(Casse casse, ArticleMagasin articleMag, int quantite) {
        Ligne_Casse l = new Ligne_Casse();
        l.setCasse(casse);
        l.setArticle(articleMag);
        l.setQuantite(quantite);
        em.persist(l);
        return l;
    }
    
    
}
