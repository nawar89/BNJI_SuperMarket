/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Article;
import EntityBean.BonCommande;
import EntityBean.LigneCommande;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nawar
 */
@Stateless
public class LigneCommandeFacade extends AbstractFacade<LigneCommande> implements LigneCommandeFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LigneCommandeFacade() {
        super(LigneCommande.class);
    }

    @Override
    public void creerLigneCommande(BonCommande command, Article article, int quantite, float prix) {
        LigneCommande ligne = new LigneCommande();
        ligne.setBonCommande(command);
        ligne.setArticle(article);
        ligne.setQuantite(quantite);
        ligne.setPrix_achat(prix);
        em.persist(ligne);
    }
    
    
    
}
