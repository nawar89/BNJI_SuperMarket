/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.BonCommande;
import EntityBean.Employe;
import EntityBean.Fournisseur;
import EntityBean.LigneCommande;
import EntityBean.Livraison;
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
public interface BonCommandeFacadeLocal {

    void create(BonCommande bonCommande);

    void edit(BonCommande bonCommande);

    void remove(BonCommande bonCommande);

    BonCommande find(Object id);

    List<BonCommande> findAll();

    List<BonCommande> findRange(int[] range);

    int count();

    BonCommande creerBonCommande(Employe chefRayon, Date datecommand, Fournisseur Fournisseur,List<Livraison> livrs,List<LigneCommande> listeLignes);
    List<BonCommande> getBonCommande(String query, ArrayList<Parametre> params) throws Exception;
    
}
