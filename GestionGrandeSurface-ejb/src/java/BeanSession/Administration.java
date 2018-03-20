/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSession;

import BeanFacade.ArticleFacadeLocal;
import BeanFacade.ArticleMagasinFacadeLocal;
import BeanFacade.BonCommandeFacadeLocal;
import BeanFacade.CategorieFacadeLocal;
import BeanFacade.EmployeFacadeLocal;
import BeanFacade.FournisseurFacadeLocal;
import BeanFacade.LigneCommandeFacadeLocal;
import BeanFacade.Ligne_livraisonFacadeLocal;
import BeanFacade.LivraisonFacadeLocal;
import BeanFacade.LotFacadeLocal;
import BeanFacade.MagasinFacadeLocal;
import BeanFacade.PromotionFacadeLocal;
import BeanFacade.ReclamationFacadeLocal;
import BeanFacade.RoleFacadeLocal;
import BeanFacade.SousCategorieFacadeLocal;
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
import EntityBean.Role;
import EntityBean.Magasin;

import EntityBean.Promotion;
import EntityBean.Reclamation;

import EntityBean.SousCategorie;
import EntityBean.Type_Reclamation;

import Structure.Parametre;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nawar
 */
@Stateless
public class Administration implements AdministrationLocal {

    @EJB
    private ArticleMagasinFacadeLocal articleMagasinFacade;

    @EJB
    private LotFacadeLocal lotFacade;

    @EJB
    private ReclamationFacadeLocal reclamationFacade;

    @EJB
    private Ligne_livraisonFacadeLocal ligne_livraisonFacade;

    @EJB
    private LivraisonFacadeLocal livraisonFacade;

    @EJB
    private LigneCommandeFacadeLocal ligneCommandeFacade;

    @EJB
    private BonCommandeFacadeLocal bonCommandeFacade;

    @EJB
    private FournisseurFacadeLocal fournisseurFacade;

    @EJB
    private PromotionFacadeLocal promotionFacade;

    @EJB
    private ArticleFacadeLocal articleFacade;

    @EJB
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private SousCategorieFacadeLocal sousCategorieFacade;

    @EJB
    private CategorieFacadeLocal categorieFacade;

    @EJB
    private RoleFacadeLocal roleFacade;

    @EJB
    private EmployeFacadeLocal employeFacade;
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @Override
     public List<Employe> getEmploye(String query, ArrayList<Parametre> params) throws Exception{
             return employeFacade.getEmploye(query, params);
     }
      @Override
     public void creerEmployee(String nom, String prenom, String adresse, String telephone, String email, String login, String mdp,Role role, Magasin magasin) {
          employeFacade.creerEmployee(nom, prenom, adresse, telephone, email, login, mdp, role, magasin );
     }
     @Override
     public void employeModifierRole(Employe emp, Role role){
            employeFacade.employeModifierRole(emp, role);
     }
     @Override
      public List<Role> getRoles(String query, List<Parametre> params) throws Exception{
          return roleFacade.getRoles(query, params);
      }

    @Override
    public void creerCategorie(String libelle) {
        categorieFacade.creerCategorie(libelle);
    }
    
    @Override
    public List<Categorie> getCategories(String query, ArrayList<Parametre> params) throws Exception{
        return categorieFacade.getCategories(query, params);
    }
    
     @Override
    public void creerSousCategorie(String libelle, Categorie categorie) {
        sousCategorieFacade.creerSousCategorie(libelle, categorie);
    }
    
     @Override
    public void creerMagasin(String adresse, String nom, String code, String ville,String horaireOuverture,String horaireFermeture,String gps) {
        magasinFacade.creerMagasin(adresse, nom, code, ville, horaireOuverture, horaireFermeture, gps);
    }
    
     @Override
    public List<Magasin> getMagasins(String query, ArrayList<Parametre> params) throws Exception{
        return magasinFacade.getMagasins(query, params);
    }

    
    @Override
    public void modifierMagasin(String nom, String adresse, String ville, String code, String horaire_ouver, String horaire_ferm, String gps, Magasin magasin) {
        magasinFacade.modifierMagasin(nom, adresse, ville, code, horaire_ouver, horaire_ferm, gps, magasin);
    }
     @Override
    public List<Article> getArticle(String query, ArrayList<Parametre> params) throws Exception{
      return articleFacade.getArticle(query, params);
    }
    
    @Override
    public void creerPromotion(Date datedeb, Date dateFin, float prix_promo, Employe dirNat, Article article) {
        promotionFacade.creerPromotion(datedeb, dateFin, prix_promo, dirNat, article);
    }
    
     @Override
    public void modifierPromotion(Date datedeb, Date dateFin, float prix_promo, Employe dirNat, Article article,Promotion p) {
        promotionFacade.creerPromotion(datedeb, dateFin, prix_promo, dirNat, article);
    }
    
      @Override
    public List<Promotion> getPromotions(String query, ArrayList<Parametre> params) throws Exception{
        return promotionFacade.getPromotions(query, params);
    }
    @Override
    public List<SousCategorie> getSousCategories(String query, ArrayList<Parametre> params) throws Exception{
        return sousCategorieFacade.getSousCategories(query, params);

    }
    
    @Override
    public List<Fournisseur> getFournisseur(String query, ArrayList<Parametre> params) throws Exception {
        return fournisseurFacade.getFournisseur(query, params);
    }
      
    @Override
    public BonCommande creerBonCommande(Employe chefRayon, Date datecommand, Fournisseur Fournisseur,List<Livraison> livrs,List<LigneCommande> listeLignes) {
        return bonCommandeFacade.creerBonCommande(chefRayon, datecommand, Fournisseur, livrs, listeLignes);
    }
    
     @Override
    public List<BonCommande> getBonCommande(String query, ArrayList<Parametre> params) throws Exception{
        return bonCommandeFacade.getBonCommande(query, params);
    }
    
     @Override
    public void creerLigneCommande(BonCommande command, Article article, int quantite, float prix) {
        ligneCommandeFacade.creerLigneCommande(command, article, quantite, prix);
    }
    
    @Override
    public void modifierLivraison(Date date_livraison, Etat_Livraison mension, Livraison liv,Employe agentLivrasion) throws Exception {
        livraisonFacade.modifierLivraison(date_livraison, mension, liv,agentLivrasion);
    }
    
       @Override
    public List<Livraison> getLivraisons(String query, ArrayList<Parametre> params) throws Exception{
        return livraisonFacade.getLivraisons(query, params);
    }
    
     @Override
    public void creerLigneLivraison(int quantite_livree, int quantite_aceptee, Article article, Livraison livraison,Date date_de_peremption) {
       ligne_livraisonFacade.creerLigneLivraison(quantite_livree, quantite_aceptee, article, livraison,date_de_peremption);
    }
    
     @Override
    public void modifierLigneLivraison(Ligne_livraison lignelivraison, int quantite_accepte) {
        ligne_livraisonFacade.modifierLigneLivraison(lignelivraison, quantite_accepte);
    }
    
     @Override
    public List<Ligne_livraison> getLignesLivraison(String query, ArrayList<Parametre> params) throws Exception{
        return ligne_livraisonFacade.getLignesLivraison(query, params);
    }
    
    @Override
    public void creerReclamation(String rec, Type_Reclamation type, Ligne_livraison ligne,Date dateRec) {
        reclamationFacade.creerReclamation(rec, type, ligne, dateRec);
    }
    
      @Override
    public List<Reclamation> getReclamations(String query, ArrayList<Parametre> params) throws Exception{
        return reclamationFacade.getReclamations(query, params);
    }
    @Override
    public void modifierEtat(Livraison liv, Etat_Livraison mension) throws Exception{
        livraisonFacade.modifierEtat(liv, mension);
    }
    
    @Override
    public void creerLot(Date date_de_peremption, int quantite, ArticleMagasin article) {
         lotFacade.creerLot(date_de_peremption, quantite, article);
    }
    
     @Override
    public List<Lot> getLots(String query, ArrayList<Parametre> params) throws Exception{
        return lotFacade.getLots(query, params);
    }
    
    @Override
    public void ajouterQuantite(ArticleMagasin articleMagasin, int quantite) {
        articleMagasinFacade.ajouterQuantite(articleMagasin, quantite);
    }
    
      @Override
    public void enleverQuantite(ArticleMagasin articleMagasin, int quantite) {
        articleMagasinFacade.enleverQuantite(articleMagasin, quantite);
    }
    
    @Override
    public void ajouterQuantiteLot(Lot lot, int quantite) {
        lotFacade.ajouterQuantiteLot(lot, quantite);
    }
    
    @Override
    public void enleverQuantiteLot(Lot lot, int quantite) {
        lotFacade.enleverQuantiteLot(lot, quantite);
    }

}
