/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSession;

import BeanFacade.ArticleFacadeLocal;
import BeanFacade.ArticleMagasinFacadeLocal;
import BeanFacade.FournisseurFacadeLocal;
import BeanFacade.LivraisonFacadeLocal;
import EntityBean.Article;
import EntityBean.ArticleMagasin;
import EntityBean.Categorie;
import EntityBean.Fournisseur;
import EntityBean.Livraison;
import EntityBean.Magasin;
import EntityBean.SousCategorie;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jihane
 */
@Stateless
public class ChefRayon implements ChefRayonLocal {

    @EJB
    private LivraisonFacadeLocal livraisonFacade;

    @EJB
    private FournisseurFacadeLocal fournisseurFacade;

    @EJB
    private ArticleMagasinFacadeLocal articleMagasinFacade;

    @EJB
    private ArticleFacadeLocal articleFacade;
    
   //Création fournisseur 
   //Création Article 
   // Modifier prix de ventes article magazin
   // Consulter livraison non comformes 
   // Analyser les ventes 
   // Commander 

    @Override
    public void creationFournisseur(String nom, String adresse, String telephone, String email) throws Exception {
        
            fournisseurFacade.creerFournisseur(nom, adresse, telephone, email);
    }
    
    @Override
    public List<Fournisseur> getFournisseur(String query, ArrayList<Parametre> params) throws Exception{
        return fournisseurFacade.getFournisseur(query, params);
    }
    
    @Override
    public void creationArticle(String libelle, String reference, float prix_achat_actuel, Date date_de_creation, String description, SousCategorie sous_categorie, Fournisseur fournisseur) throws Exception {
    
    articleFacade.creerArticle(libelle, reference, prix_achat_actuel, date_de_creation, description, sous_categorie, fournisseur);
     
    }
    
    @Override
    public List<Article> getArticle(String query, ArrayList<Parametre> params) throws Exception{
        return articleFacade.getArticle(query, params);
    }
    
    @Override
    public void creationArticleMag(int quantite, float prix_vente_actuel, Article article, Magasin magasin) throws Exception {
        articleMagasinFacade.creerArticleMag(quantite, prix_vente_actuel, article, magasin);
    }
    @Override
    public List<ArticleMagasin> getArticleMagasin(String query, ArrayList<Parametre> params) throws Exception{
        return articleMagasinFacade.getArticleMagasin(query, params);
    }
    
     @Override
    public void modifierPrixVente(ArticleMagasin articleMagasin, float nouveauPrix) 
    {
        articleMagasinFacade.modifierPrixVente(articleMagasin, nouveauPrix);
    }
    
     @Override
    public List<Livraison> getLivraison(String query, ArrayList<Parametre> params) throws Exception{
        return livraisonFacade.getLivraisons(query, params);
    }
    
    

}
    
   
    
    
