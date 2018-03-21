/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Electromenager;
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
public class ElectromenagerFacade extends AbstractFacade<Electromenager> implements ElectromenagerFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ElectromenagerFacade() {
        super(Electromenager.class);
    }
    
     //Creation article
    @Override
    public void creerElec(String libelle, String reference, float prix_achat_actuel, Date date_de_creation, String description, SousCategorie sous_categorie, Fournisseur fournisseur, int period_garantie) throws Exception {
        try {
        Electromenager elec = new Electromenager();
        elec.setLibelle(libelle);
        elec.setReference(reference);
        elec.setPrix_achat_actuel(prix_achat_actuel);
        elec.setDate_creation(date_de_creation);
        elec.setSousCategorie(sous_categorie);
        elec.setFournisseur(fournisseur);
        elec.setPeriod_garantie(period_garantie);
        em.persist(elec);  
    } catch(Exception exe){throw exe;}
    }
    
    
   
     //Recherche d'aticle 
    @Override
    public List<Electromenager> getElectro(String query, ArrayList<Parametre> params) throws Exception{
        List<Electromenager> elec = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            elec = q.getResultList();
        }catch(Exception exe){
            //throw exe;
        }
        return elec;
    }
    
}
