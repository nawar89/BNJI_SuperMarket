/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Article;
import EntityBean.Fournisseur;
import EntityBean.Produit_Frais;
import EntityBean.SousCategorie;
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
public class Produit_FraisFacade extends AbstractFacade<Produit_Frais> implements Produit_FraisFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Produit_FraisFacade() {
        super(Produit_Frais.class);
    }
    
    
    //Creation article
    @Override
    public void creerProduitFrais(String libelle, String reference, float prix_achat_actuel, Date date_de_creation, String description, SousCategorie sous_categorie, Fournisseur fournisseur) throws Exception {
        try {
        Produit_Frais prod = new Produit_Frais();
        prod.setLibelle(libelle);
        prod.setReference(reference);
        prod.setPrix_achat_actuel(prix_achat_actuel);
        prod.setDate_creation(date_de_creation);
        prod.setSousCategorie(sous_categorie);
        prod.setFournisseur(fournisseur);
        
        em.persist(prod);  
    } catch(Exception exe){throw exe;}
    }
    
   //Recherche d'aticle 
    @Override
    public List<Produit_Frais> getProduitFrais(String query, ArrayList<Parametre> params) throws Exception{
        List<Produit_Frais> prod = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            prod = q.getResultList();
        }catch(Exception exe){
            //throw exe;
        }
        return prod;
    }

}
