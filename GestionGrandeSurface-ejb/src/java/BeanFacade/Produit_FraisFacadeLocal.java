/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Fournisseur;
import EntityBean.Produit_Frais;
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
public interface Produit_FraisFacadeLocal {

    void create(Produit_Frais produit_Frais);

    void edit(Produit_Frais produit_Frais);

    void remove(Produit_Frais produit_Frais);

    Produit_Frais find(Object id);

    List<Produit_Frais> findAll();

    List<Produit_Frais> findRange(int[] range);
    void creerProduitFrais(String libelle, String reference, float prix_achat_actuel, Date date_de_creation, String description, SousCategorie sous_categorie, Fournisseur fournisseur, Date date_premption) throws Exception;
    List<Produit_Frais> getProduitFrais(String query, ArrayList<Parametre> params) throws Exception;
    int count();
    
}
