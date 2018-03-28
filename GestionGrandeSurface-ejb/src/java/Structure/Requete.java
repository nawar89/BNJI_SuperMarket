/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

/**
 *
 * @author Nawar
 */
public abstract class Requete {
    public static String getRoles = "SELECT r FROM Role AS r WHERE 1=1";
    public static String getEmployes = "SELECT e FROM Employe AS e WHERE 1=1";
    public static String getArticles = "SELECT a FROM Article AS a WHERE 1=1";
    public static String getVetement = "SELECT v FROM Vetement AS v WHERE 1=1";
    public static String getElectromenager = "SELECT e FROM Electromenager AS e WHERE 1=1";
    public static String getProduitFrais = "SELECT p FROM Produit_Frais AS a WHERE 1=1";
    public static String getArticleMagasin = "SELECT a FROM ArticleMagasin AS a WHERE 1=1";
    public static String getCategories = "SELECT c FROM Categorie AS c WHERE 1=1";
    public static String getSousCategories = "SELECT s FROM SousCategorie AS s WHERE 1=1";
    public static String getMagasins = "SELECT m FROM Magasin AS m WHERE 1=1";
    public static String getPromotions = "SELECT p FROM Promotion AS p WHERE 1=1";
    public static String getFournisseurs = "SELECT f FROM Fournisseur AS f WHERE 1=1";
    public static String getBonCommandes = "SELECT b FROM BonCommande AS b WHERE 1=1";
    public static String getLivraisons = "SELECT l FROM Livraison AS l WHERE 1=1";
    public static String getCommandesParFournisseurLivr = "select b from BonCommande as b join b.fournisseur f where 1=1 and b.livraisons is empty";
    public static String getCommandesParMagasin = "select b from BonCommande b join b.chefRyon cr join cr.magasin m where 1=1" ;
    public static String getLivraisonParMagasin = "select l from Livraison l join l.bonCommande c join c.chefRyon cr join cr.magasin m where 1=1" ;
    public static String getCommandes = "select b from BonCommande b where 1=1";
    public static String getLivraisonsParMagasin = "select l from Livraison l join l.bonCommande b join b.chefRyon cr join cr.magasin m where 1=1" ;
    public static String getArticlesMagasinParMagasin = "select a from ArticleMagasin a join a.magasin m where 1=1" ;
    public static String getLotParMagasin = "select l from Lot l join l.articleMagasin a join a.magasin m where 1=1" ;
    public static String getLots = "select l from Lot l where 1=1";
    public static String getCasseParEmploye = "select c from Casse c join c.agentRayon a where 1=1";
    public static String getLigneLivraisons = "select l from Ligne_livraison l where 1=1";
    public static String getArticlesMagasinParMagasinCategorie = "select a from ArticleMagasin a join a.magasin m join a.article art join art.sousCategorie s join s.categorie c where 1=1" ;
    public static String getCasses ="select c from Casse c where 1=1";
    public static String getReclamationParFournisseur = "select r from Reclamation As r join r.ligneLivraison lv join lv.livraison liv join liv.fournisseur f where 1=1";
    public static String getLivraisonsParFournisseur = "SELECT L FROM Livraison L join L.fournisseur f WHERE 1=1";
    public static String getClients = "SELECT c FROM Client AS c WHERE 1=1";
    public static String getArticleParArticleMagasin = "select a from Article a join a.articleMagasins am where 1=1" ;
    public static String getLigneCommandeEnLigne = "select l from ligneCommandeEnLigne AS l where 1=1" ;
    public static String getArticleMagasinParChefRayon = "SELECT a FROM ArticleMagasin AS a join a.magasin m join m.employes emp WHERE 1=1";
    public static String getCommandeClient= "Select l From ligneCommandeEnLigne as l join l.commandeClient lc join l.articleMagasin ar join ar.magasin m WHERE 1=1";
    public static String getCommandeClientParmag= "Select l From ligneCommandeEnLigne as l join l.commandeClient lc join l.articleMagasin ar join ar.magasin m WHERE 1=1";
    public static String getLignesCommande = "SELECT l FROM LigneCommande AS l WHERE 1=1";
    
    
    
}


