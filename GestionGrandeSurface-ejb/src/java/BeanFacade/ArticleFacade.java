/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Article;
import EntityBean.Fournisseur;
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
 * @author Nawar
 */
@Stateless
public class ArticleFacade extends AbstractFacade<Article> implements ArticleFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleFacade() {
        super(Article.class);
    }
    
   //Creation article
    @Override
    public void creerArticle(String libelle, String reference, float prix_achat_actuel, Date date_de_creation, String description, SousCategorie sous_categorie, Fournisseur fournisseur) throws Exception {
        try {
        Article article = new Article();
        article.setLibelle(libelle);
        article.setReference(reference);
        article.setPrix_achat_actuel(prix_achat_actuel);
        article.setDate_creation(date_de_creation);
        article.setSousCategorie(sous_categorie);
        article.setFournisseur(fournisseur);
        em.persist(article);  
    } catch(Exception exe){throw exe;}
    }
    
   //Recherche d'aticle 
    @Override
    public List<Article> getArticle(String query, ArrayList<Parametre> params) throws Exception{
        List<Article> articles = null;
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
    
   
    
    
}
