/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Article;
import EntityBean.ArticleMagasin;
import EntityBean.Magasin;
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
 * @author Jihane
 */
@Stateless
public class ArticleMagasinFacade extends AbstractFacade<ArticleMagasin> implements ArticleMagasinFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleMagasinFacade() {
        super(ArticleMagasin.class);
    }
    // Creer article du magasin
    @Override
    public void creerArticleMag(int quantite, float prix_vente_actuel, Article article, Magasin magasin) throws Exception{
        try {
            ArticleMagasin a = new ArticleMagasin();
            a.setQuantite(quantite);
            a.setPrix_vente_actuel(prix_vente_actuel);
            a.setArticle(article);
            a.setMagasin(magasin);
            em.persist(a);
            
        }catch(Exception ex){throw ex;}
    }
    
    //Rechercher un article de magasin
     @Override
    public List<ArticleMagasin> getArticleMagasin(String query, ArrayList<Parametre> params) throws Exception{
        List<ArticleMagasin> articles = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            articles = q.getResultList();
        }catch(Exception exe){throw exe;}
        return articles;
    }
    //Modifier Prix de vente : 

    @Override
    public void modifierPrixVente(ArticleMagasin articleMagasin, float nouveauPrix) {
        articleMagasin.setPrix_vente_actuel(nouveauPrix);
        em.merge(articleMagasin);
    }
   
    
}
