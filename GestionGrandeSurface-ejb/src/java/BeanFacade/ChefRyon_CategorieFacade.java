/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Categorie;
import EntityBean.ChefRyon_Categorie;
import EntityBean.Employe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author i.silvestre
 */
@Stateless
public class ChefRyon_CategorieFacade extends AbstractFacade<ChefRyon_Categorie> implements ChefRyon_CategorieFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChefRyon_CategorieFacade() {
        super(ChefRyon_Categorie.class);
    }

    @Override
    public void creerRelationEmployeRayon(Employe employe, Categorie categorie) {
        ChefRyon_Categorie relation = new ChefRyon_Categorie();
        relation.setCategorie(categorie);
        relation.setChefRyon(employe);
        em.persist(relation);
    }

    @Override
    public void supprimerRelationEmployeCat(ChefRyon_Categorie relation) {
        em.remove(relation);
    }
    
    
}
