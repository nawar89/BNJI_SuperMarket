/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSession;

import EntityBean.Article;
import EntityBean.ArticleMagasin;
import EntityBean.Fournisseur;
import EntityBean.Livraison;
import EntityBean.Magasin;
import EntityBean.SousCategorie;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jihane
 */
@Local
public interface ChefRayonLocal {

    void creationFournisseur(String nom, String adresse, String telephone, String email) throws Exception;
    List<Fournisseur> getFournisseur(String query, ArrayList<Parametre> params) throws Exception;
    void creationArticle(String libelle, String reference, float prix_achat_actuel, Date date_de_creation, String description, SousCategorie sous_categorie, Fournisseur fournisseur) throws Exception ;
    List<Article> getArticle(String query, ArrayList<Parametre> params) throws Exception;
    void creationArticleMag(int quantite, float prix_vente_actuel, Article article, Magasin magasin) throws Exception;
    List<ArticleMagasin> getArticleMagasin(String query, ArrayList<Parametre> params) throws Exception;
    void modifierPrixVente(ArticleMagasin articleMagasin, float nouveauPrix) ;
    List<Livraison> getLivraison(String query, ArrayList<Parametre> params) throws Exception;
}

