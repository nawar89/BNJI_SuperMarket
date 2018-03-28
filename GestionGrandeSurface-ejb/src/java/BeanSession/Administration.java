/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSession;

import BeanFacade.ArticleFacadeLocal;
import BeanFacade.ArticleMagasinFacadeLocal;
import BeanFacade.BonCommandeFacadeLocal;
import BeanFacade.CasseFacadeLocal;
import BeanFacade.CategorieFacadeLocal;
import BeanFacade.ChefRyon_CategorieFacadeLocal;
import BeanFacade.ElectromenagerFacadeLocal;
import BeanFacade.EmployeFacadeLocal;
import BeanFacade.FournisseurFacadeLocal;
import BeanFacade.LigneCommandeFacadeLocal;
import BeanFacade.Ligne_CasseFacadeLocal;
import BeanFacade.Ligne_livraisonFacadeLocal;
import BeanFacade.LivraisonFacadeLocal;
import BeanFacade.LotFacadeLocal;
import BeanFacade.MagasinFacadeLocal;
import BeanFacade.Produit_FraisFacadeLocal;
import BeanFacade.PromotionFacadeLocal;
import BeanFacade.ReclamationFacadeLocal;
import BeanFacade.RoleFacadeLocal;
import BeanFacade.SousCategorieFacadeLocal;
import BeanFacade.VetementFacadeLocal;
import EntityBean.Article;
import EntityBean.ArticleMagasin;
import EntityBean.BonCommande;
import EntityBean.Casse;
import EntityBean.Categorie;
import EntityBean.Electromenager;
import EntityBean.Employe;
import EntityBean.Etat_Livraison;
import EntityBean.Fournisseur;
import EntityBean.LigneCommande;
import EntityBean.Ligne_Casse;
import EntityBean.Ligne_livraison;
import EntityBean.Livraison;
import EntityBean.Lot;
import EntityBean.Role;
import EntityBean.Magasin;
import EntityBean.Produit_Frais;

import EntityBean.Promotion;
import EntityBean.Reclamation;

import EntityBean.SousCategorie;
import EntityBean.Type_Reclamation;
import EntityBean.Vetement;
import Structure.Aide;

import Structure.Parametre;
import Structure.Requete;
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
    private ElectromenagerFacadeLocal electromenagerFacade;

    @EJB
    private VetementFacadeLocal vetementFacade;

    @EJB
    private Produit_FraisFacadeLocal produit_FraisFacade;

    @EJB
    private Ligne_CasseFacadeLocal ligne_CasseFacade;

    @EJB
    private ChefRyon_CategorieFacadeLocal chefRyon_CategorieFacade;

    @EJB
    private CasseFacadeLocal casseFacade;

    @EJB
    private ArticleMagasinFacadeLocal articleMagasinFacade1;

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
    
    @Override
    public ArticleMagasin creerArticleMag(int quantite, float prix_vente_actuel, Article article, Magasin magasin) throws Exception{
        return articleMagasinFacade.creerArticleMag(quantite, prix_vente_actuel, article, magasin);
    }
    
    @Override
    public List<ArticleMagasin> getArticleMagasin(String query, ArrayList<Parametre> params) throws Exception{
        return articleMagasinFacade.getArticleMagasin(query, params);
        
    }
    
    @Override
    public void modifierPrixVente(ArticleMagasin articleMagasin, float nouveauPrix) {
        articleMagasinFacade.modifierPrixVente(articleMagasin, nouveauPrix);
    }
     @Override
    public Livraison creerLivraison(Date date_livraison, Date date_livraison_prevu, Fournisseur fournisseur, BonCommande bon_commande, Etat_Livraison mension) throws Exception {
       return livraisonFacade.creerLivraison(date_livraison, date_livraison_prevu, fournisseur, bon_commande, mension);
    }
    
     @Override
    public List<Casse> getCasse(String query, ArrayList<Parametre> params) throws Exception{
        return casseFacade.getCasses(query, params);
    }
    @Override
     public void creerEmployeMagasin(String nom, String prenom, String adresse, String telephone, String email, String login, String mdp, Role role, Magasin magasin, List<Categorie> listeCat ) throws  Exception
    {
        employeFacade.creerEmployee(nom, prenom, adresse, telephone, email, login, mdp, role, magasin );
        if (role.getNom().equals("ChefRayon") || role.getNom().equals("AgRayon"))
        {
            try {
                ArrayList<Parametre> mesParam = new ArrayList<>();
                Parametre p = new Parametre("login", "String", login);
                mesParam.add(p);
                p = new Parametre("mdp", "String", mdp);
                mesParam.add(p);
                
                List<Employe> listeEmp = getEmploye(Requete.getEmployes + " AND e.login = :login AND e.mdp = :mdp", mesParam);
                if(!listeEmp.isEmpty() && listeEmp.size()==1)
                {
                    Employe employe = (Employe)Aide.getObjectDeListe(listeEmp.toArray());
                
                    listeCat.forEach((cat) -> {
                        chefRyon_CategorieFacade.creerRelationEmployeRayon(employe, cat);
                    });
                }
                
                
            } catch (Exception ex) {
                throw ex;
            }
            
        }
         
     }
     
      @Override
    public Casse creerCasse(Employe agentRayon, Date date) {
        Casse casse = casseFacade.creerCasse(agentRayon, date);
        return casse;
    }

    @Override
    public Ligne_Casse creerLigneCasse(Lot lot, ArticleMagasin articleMag, int quantite, Casse casse) 
    {
        Ligne_Casse ligne = ligne_CasseFacade.creerLigneCasse(casse, articleMag, quantite);
        articleMagasinFacade.modifierQuantiteStock(articleMag, quantite);
        if (lot !=null)
        {
            lotFacade.enleverQuantiteLot(lot, quantite);   
        }
        
        return ligne; 
    }
    
    
    @Override
    public void creationFournisseur(String nom, String adresse, String telephone, String email,String mdp) throws Exception {
        
            fournisseurFacade.creerFournisseur(nom, adresse, telephone, email,mdp);
    }
    
    @Override
    public void creationArticle(String libelle, String reference, float prix_achat_actuel, Date date_de_creation, String description, SousCategorie sous_categorie, Fournisseur fournisseur,String img) throws Exception {
    
    articleFacade.creerArticle(libelle, reference, prix_achat_actuel, date_de_creation, description, sous_categorie, fournisseur,img);
     
    }
    
    @Override
    public void creationArticleMag(int quantite, float prix_vente_actuel, Article article, Magasin magasin) throws Exception {
        articleMagasinFacade.creerArticleMag(quantite, prix_vente_actuel, article, magasin);
    }
    
     @Override
    public void creationProdFrais(String libelle, String reference, float prix_achat_actuel, Date date_de_creation, String description, SousCategorie sous_categorie, Fournisseur fournisseur,String img) throws Exception {
    
    produit_FraisFacade.creerProduitFrais(libelle, reference, prix_achat_actuel, date_de_creation, description, sous_categorie, fournisseur,img);
     
    }
    
    @Override
    public List<Produit_Frais> getProdFrais(String query, ArrayList<Parametre> params) throws Exception{
        return produit_FraisFacade.getProduitFrais(query, params);
    }
    
     @Override
    public void creationVetement(String libelle, String reference, float prix_achat_actuel, Date date_de_creation, String description, SousCategorie sous_categorie, Fournisseur fournisseur,String img,String taille, String coloris) throws Exception {
    
    vetementFacade.creerVetement(libelle, reference, prix_achat_actuel, date_de_creation, description, sous_categorie, fournisseur, img, taille, coloris);
     
    }
    
    @Override
    public List<Vetement> getVetement(String query, ArrayList<Parametre> params) throws Exception{
        return vetementFacade.getVetement(query, params);
    }
    
     @Override
    public void creationElectromenager(String libelle, String reference, float prix_achat_actuel, Date date_de_creation, String description, SousCategorie sous_categorie, Fournisseur fournisseur,String img,int period_garantie) throws Exception {
    
    electromenagerFacade.creerElec(libelle, reference, prix_achat_actuel, date_de_creation, description, sous_categorie, fournisseur,img,period_garantie);
     
    }
    @Override
    public List<Electromenager> getElectro(String query, ArrayList<Parametre> params) throws Exception{
        return electromenagerFacade.getElectro(query, params);
    }
   
    
    @Override
   public void creationLivraison(Date date_livraison, Date date_livraison_prevu, Fournisseur fournisseur, BonCommande bon_commande, Etat_Livraison mension) throws Exception {
       livraisonFacade.creerLivraison(date_livraison, date_livraison_prevu, fournisseur, bon_commande, mension);
    }
   
    @Override
    public List<LigneCommande> getLigneCommandes(String query, ArrayList<Parametre> params) throws Exception{
        return ligneCommandeFacade.getLigneCommandes(query, params);
    }
    
    
    
    

}
