/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.BonCommande;
import EntityBean.Employe;
import EntityBean.Etat_Livraison;
import EntityBean.Fournisseur;
import EntityBean.Livraison;
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
public interface LivraisonFacadeLocal {

    void create(Livraison livraison);

    void edit(Livraison livraison);

    void remove(Livraison livraison);

    Livraison find(Object id);

    List<Livraison> findAll();

    List<Livraison> findRange(int[] range);

    int count();

    void creerLivraison(Date date_livraison, Date date_livraison_prevu, Fournisseur fournisseur, BonCommande bon_commande, Etat_Livraison mension) throws Exception ;
      
    List<Livraison> getLivraisons(String query, ArrayList<Parametre> params) throws Exception;
    
    void modifierLivraison(Date date_livraison, Etat_Livraison mension, Livraison liv,Employe agentLivrasion) throws Exception;
}
