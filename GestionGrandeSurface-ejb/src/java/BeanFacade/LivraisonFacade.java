/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;
import EntityBean.BonCommande;
import EntityBean.Employe;
import EntityBean.Etat_Livraison;
import EntityBean.Fournisseur;
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
 * @author Jihane
 */
@Stateless
public class LivraisonFacade extends AbstractFacade<Livraison> implements LivraisonFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LivraisonFacade() {
        super(Livraison.class);
    }

    @Override
    public void creerLivraison(Date date_livraison, Date date_livraison_prevu, Fournisseur fournisseur, BonCommande bon_commande, Etat_Livraison mension) throws Exception {
        try {
            Livraison livraison = new Livraison();
            livraison.setDate_livraison(date_livraison);
            livraison.setDate_livraison_prevu(date_livraison_prevu);
            livraison.setFournisseur(fournisseur);
            livraison.setBonCommande(bon_commande);
            livraison.setMention(mension);
            em.persist(livraison);
        }catch(Exception ex){throw ex;} 
    }

   
    //Rechercher livraison
     @Override
    public List<Livraison> getLivraisons(String query, ArrayList<Parametre> params) throws Exception{
        List<Livraison> livraisons= null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            livraisons = q.getResultList();
        }catch(Exception exe){throw exe;}
        return livraisons;
    }
    
    @Override
    public void modifierLivraison(Date date_livraison, Etat_Livraison mension, Livraison liv,Employe agentLivrasion) throws Exception {
        liv.setDate_livraison(date_livraison);
        liv.setAgentLivraison(agentLivrasion);
        liv.setMention(mension);
        em.merge(liv);
    }
    
            
    @Override
    public void modifierEtat(Livraison liv, Etat_Livraison mension) throws Exception {
        liv.setMention(mension);
        em.merge(liv);
    }
    
}
