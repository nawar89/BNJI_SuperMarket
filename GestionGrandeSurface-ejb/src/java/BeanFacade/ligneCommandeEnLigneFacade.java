/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.ArticleMagasin;
import EntityBean.CommandeClientEnLigne;
import EntityBean.ligneCommandeEnLigne;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nawar
 */
@Stateless
public class ligneCommandeEnLigneFacade extends AbstractFacade<ligneCommandeEnLigne> implements ligneCommandeEnLigneFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ligneCommandeEnLigneFacade() {
        super(ligneCommandeEnLigne.class);
    }

    @Override
    public ligneCommandeEnLigne creerLigneCommandeEnligne(CommandeClientEnLigne commande, ArticleMagasin article, int quantite,float prix,boolean promo) {
        ligneCommandeEnLigne l = new ligneCommandeEnLigne();
        l.setArticleMagasin(article);
        l.setCommandeClient(commande);
        l.setQuantite(quantite);
        l.setPrix_vente(prix);
        l.setEnPromo(promo);
        em.persist(l);
        return l;
    }
    
}
