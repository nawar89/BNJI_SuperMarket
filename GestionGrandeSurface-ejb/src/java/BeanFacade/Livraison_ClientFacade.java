/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.CommandeClientEnLigne;
import EntityBean.Livraison_Client;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nawar
 */
@Stateless
public class Livraison_ClientFacade extends AbstractFacade<Livraison_Client> implements Livraison_ClientFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Livraison_ClientFacade() {
        super(Livraison_Client.class);
    }

    @Override
    public Livraison_Client creerLivraisonClient(Date dateLiv, Date datePrevu, CommandeClientEnLigne commande) {
        Livraison_Client lc = new Livraison_Client();
        lc.setCommandeClient(commande);
        lc.setDate_prevu(datePrevu);
        lc.setDate_livraison(dateLiv);
        em.persist(lc);
        return lc;
    }
    
    
    
}
