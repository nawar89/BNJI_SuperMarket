/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Article;
import EntityBean.Ligne_livraison;
import EntityBean.Livraison;
import Structure.Aide;
import Structure.Parametre;
import java.util.ArrayList;
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
public class Ligne_livraisonFacade extends AbstractFacade<Ligne_livraison> implements Ligne_livraisonFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Ligne_livraisonFacade() {
        super(Ligne_livraison.class);
    }

    @Override
    public void creerLigneLivraison(int quantite_livree, int quantite_aceptee, Article article, Livraison livraison) {
        Ligne_livraison l = new Ligne_livraison();
        l.setQuantite_livree(quantite_livree);
        l.setQuantite_accepte(quantite_aceptee);
        l.setArticle(article);
        l.setLivraison(livraison);
        em.persist(l);
    }

    @Override
    public void modifierLigneLivraison(Ligne_livraison lignelivraison, int quantite_accepte) {
        lignelivraison.setQuantite_accepte(quantite_accepte);
        em.merge(lignelivraison);
    }
    
     @Override
    public List<Ligne_livraison> getLignesLivraison(String query, ArrayList<Parametre> params) throws Exception{
        List<Ligne_livraison> lignes = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            lignes = q.getResultList();
        }catch(Exception exe){throw exe;}
        return lignes;
    }
    
    
    
}
