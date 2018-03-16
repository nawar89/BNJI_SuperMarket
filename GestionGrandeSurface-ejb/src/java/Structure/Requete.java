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
    public static String getArticleMagasin = "SELECT a FROM ArticleMagasin AS a WHERE 1=1";
    public static String getCategories = "SELECT c FROM Categorie AS c WHERE 1=1";
    public static String getSousCategories = "SELECT s FROM SousCategorie AS s WHERE 1=1";
    public static String getMagasins = "SELECT m FROM Magasin AS m WHERE 1=1";
    public static String getPromotions = "SELECT p FROM Promotion AS p WHERE 1=1";
    public static String getFournisseurs = "SELECT f FROM Fournisseur AS f WHERE 1=1";
    public static String getBonCommandes = "SELECT b FROM BonCommande AS b WHERE 1=1";
    public static String getLivraisons = "SELECT l FROM Livraison AS l WHERE 1=1";
}
