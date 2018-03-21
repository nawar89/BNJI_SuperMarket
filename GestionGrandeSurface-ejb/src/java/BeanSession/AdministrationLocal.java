/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSession;

import EntityBean.Article;
import EntityBean.ArticleMagasin;
import EntityBean.BonCommande;
import EntityBean.Categorie;
import EntityBean.Employe;
import EntityBean.Etat_Livraison;
import EntityBean.Fournisseur;
import EntityBean.LigneCommande;
import EntityBean.Ligne_livraison;
import EntityBean.Livraison;
import EntityBean.Lot;
import EntityBean.Magasin;
import EntityBean.Promotion;
import EntityBean.Reclamation;
import EntityBean.Role;
import EntityBean.SousCategorie;
import EntityBean.Type_Reclamation;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nawar
 */
@Local
public interface AdministrationLocal {
    List<Employe> getEmploye(String query, ArrayList<Parametre> params) throws Exception;
    void creerEmployee(String nom, String prenom, String adresse, String telephone, String email, String login, String mdp,Role role, Magasin magasin);
    void employeModifierRole(Employe emp, Role role);
    List<Role> getRoles(String query, List<Parametre> params) throws Exception;

    void creerCategorie(String libelle);
    
    List<Categorie> getCategories(String query, ArrayList<Parametre> params) throws Exception;
    
    void creerSousCategorie(String libelle, Categorie categorie);
    
    void creerMagasin(String adresse, String nom, String code, String ville,String horaireOuverture,String horaireFermeture,String gps);
    List<Magasin> getMagasins(String query, ArrayList<Parametre> params) throws Exception;

    
    void modifierMagasin(String nom, String adresse, String ville, String code, String horaire_ouver, String horaire_ferm, String gps, Magasin magasin);
    
    List<Article> getArticle(String query, ArrayList<Parametre> params) throws Exception;
    
    void creerPromotion(Date datedeb, Date dateFin, float prix_promo, Employe dirNat, Article article);
    
    void modifierPromotion(Date datedeb, Date dateFin, float prix_promo, Employe dirNat, Article article,Promotion p);
    
    List<Promotion> getPromotions(String query, ArrayList<Parametre> params) throws Exception;
    

    List<SousCategorie> getSousCategories(String query, ArrayList<Parametre> params) throws Exception;
    
    List<Fournisseur> getFournisseur(String query, ArrayList<Parametre> params) throws Exception;
    
    BonCommande creerBonCommande(Employe chefRayon, Date datecommand, Fournisseur Fournisseur,List<Livraison> livrs,List<LigneCommande> listeLignes) ;
    
    List<BonCommande> getBonCommande(String query, ArrayList<Parametre> params) throws Exception;
    
    void creerLigneCommande(BonCommande command, Article article, int quantite, float prix);
    
    void modifierLivraison(Date date_livraison, Etat_Livraison mension, Livraison liv,Employe agentLivrasion) throws Exception;
    
    List<Livraison> getLivraisons(String query, ArrayList<Parametre> params) throws Exception;
    
    void creerLigneLivraison(int quantite_livree, int quantite_aceptee, Article article, Livraison livraison,Date date_de_peremption);
    
    void modifierLigneLivraison(Ligne_livraison lignelivraison, int quantite_accepte) ;
    
    List<Ligne_livraison> getLignesLivraison(String query, ArrayList<Parametre> params) throws Exception;
    
    void creerReclamation(String rec, Type_Reclamation type, Ligne_livraison ligne,Date dateRec) ;
    
    List<Reclamation> getReclamations(String query, ArrayList<Parametre> params) throws Exception;
    
    void modifierEtat(Livraison liv, Etat_Livraison mension) throws Exception;
    
    void creerLot(Date date_de_peremption, int quantite, ArticleMagasin article);
    
    List<Lot> getLots(String query, ArrayList<Parametre> params) throws Exception;
    
    void ajouterQuantite(ArticleMagasin articleMagasin, int quantite);
    
    void enleverQuantite(ArticleMagasin articleMagasin, int quantite);
    
    void ajouterQuantiteLot(Lot lot, int quantite);
    
    void enleverQuantiteLot(Lot lot, int quantite);
    
    ArticleMagasin creerArticleMag(int quantite, float prix_vente_actuel, Article article, Magasin magasin) throws Exception;
    
    List<ArticleMagasin> getArticleMagasin(String query, ArrayList<Parametre> params) throws Exception;
    
    void modifierPrixVente(ArticleMagasin articleMagasin, float nouveauPrix);
    
    Livraison creerLivraison(Date date_livraison, Date date_livraison_prevu, Fournisseur fournisseur, BonCommande bon_commande, Etat_Livraison mension) throws Exception;
    
}
