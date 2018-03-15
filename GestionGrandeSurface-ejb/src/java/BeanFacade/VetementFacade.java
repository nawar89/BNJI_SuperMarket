/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Fournisseur;
import EntityBean.Produit_Frais;
import EntityBean.SousCategorie;
import EntityBean.Vetement;
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
public class VetementFacade extends AbstractFacade<Vetement> implements VetementFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VetementFacade() {
        super(Vetement.class);
    }
    //Creation article
    @Override
    public void creerVetement(String libelle, String reference, float prix_achat_actuel, Date date_de_creation, String description, SousCategorie sous_categorie, Fournisseur fournisseur, String taille,String coloris) throws Exception {
        try {
        Vetement vetement = new Vetement();
        vetement.setLibelle(libelle);
        vetement.setReference(reference);
        vetement.setPrix_achat_actuel(prix_achat_actuel);
        vetement.setDate_creation(date_de_creation);
        vetement.setSousCategorie(sous_categorie);
        vetement.setFournisseur(fournisseur);
        vetement.setTaille(taille);
        vetement.setColoris(coloris);
        em.persist(vetement);  
    } catch(Exception exe){throw exe;}
    }
    
   //Recherche d'aticle 
    @Override
    public List<Vetement> getVetement(String query, ArrayList<Parametre> params) throws Exception{
        List<Vetement> vetement = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            vetement = q.getResultList();
        }catch(Exception exe){throw exe;}
        return vetement;
    }
    
}
