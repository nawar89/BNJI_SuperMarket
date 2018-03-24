/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.ArticleMagasin;
import EntityBean.CommandeClientEnLigne;
import EntityBean.ligneCommandeEnLigne;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nawar
 */
@Local
public interface ligneCommandeEnLigneFacadeLocal {

    void create(ligneCommandeEnLigne ligneCommandeEnLigne);

    void edit(ligneCommandeEnLigne ligneCommandeEnLigne);

    void remove(ligneCommandeEnLigne ligneCommandeEnLigne);

    ligneCommandeEnLigne find(Object id);

    List<ligneCommandeEnLigne> findAll();

    List<ligneCommandeEnLigne> findRange(int[] range);

    int count();

    
    ligneCommandeEnLigne creerLigneCommandeEnligne(CommandeClientEnLigne commande, ArticleMagasin article, int quantite,float prix,boolean promo);

    void modifierLigneCommandeEnLigne(ligneCommandeEnLigne ligne, int quantite);

    void supprimerLigneCommandeEnLigne(ligneCommandeEnLigne ligne);
    
    List<ligneCommandeEnLigne> getLigneCommandeEnligne(String query, ArrayList<Parametre> params) throws Exception;
    
}
