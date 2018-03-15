/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.BonCommande;
import EntityBean.Employe;
import EntityBean.Fournisseur;
import EntityBean.LigneCommande;
import EntityBean.Livraison;
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
public class BonCommandeFacade extends AbstractFacade<BonCommande> implements BonCommandeFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BonCommandeFacade() {
        super(BonCommande.class);
    }

    @Override
    public void creerBonCommande(Employe chefRayon, Date datecommand, Fournisseur Fournisseur,List<Livraison> livrs,List<LigneCommande> listeLignes) {
        BonCommande b = new BonCommande();
        b.setChefRyon(chefRayon);
        b.setDate_commande(datecommand);
        b.setFournisseur(Fournisseur);
        b.setLigneCommandes(listeLignes);
        b.setLivraisons(livrs);
        em.persist(b);
    }
    
    
    @Override
    public List<BonCommande> getBonCommande(String query, ArrayList<Parametre> params) throws Exception{
        List<BonCommande> commandes = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            commandes = q.getResultList();
        }catch(Exception exe){throw exe;}
        return commandes;
    }
    
}
