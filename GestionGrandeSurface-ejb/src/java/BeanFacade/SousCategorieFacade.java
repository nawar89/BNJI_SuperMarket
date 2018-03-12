/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Categorie;
import EntityBean.SousCategorie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nawar
 */
@Stateless
public class SousCategorieFacade extends AbstractFacade<SousCategorie> implements SousCategorieFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SousCategorieFacade() {
        super(SousCategorie.class);
    }

    @Override
    public void creerSousCategorie(String libelle, Categorie categorie) {
        SousCategorie s = new SousCategorie();
        s.setLibelle(libelle);
        s.setCategorie(categorie);
        em.persist(s);
    }
    
    
    
}
