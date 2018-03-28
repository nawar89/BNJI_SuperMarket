/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Article;
import EntityBean.BonCommande;
import EntityBean.LigneCommande;
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
    
   
    
     @Override
    public List<LigneCommande> getLigneCommandes(String query, ArrayList<Parametre> params) throws Exception{
        List<LigneCommande> articles = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            articles = q.getResultList();
        }catch(Exception exe){//throw exe;
        }
        return articles;
    }
    
    
    
}
