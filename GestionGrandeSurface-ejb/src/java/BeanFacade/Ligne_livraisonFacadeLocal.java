/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Article;
import EntityBean.Ligne_livraison;
import EntityBean.Livraison;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nawar
 */
@Local
public interface Ligne_livraisonFacadeLocal {

    void create(Ligne_livraison ligne_livraison);

    void edit(Ligne_livraison ligne_livraison);

    void remove(Ligne_livraison ligne_livraison);

    Ligne_livraison find(Object id);

    List<Ligne_livraison> findAll();

    List<Ligne_livraison> findRange(int[] range);

    int count();

    void creerLigneLivraison(int quantite_livree, int quantite_aceptee, Article article, Livraison livraison);

    void modifierLigneLivraison(Ligne_livraison lignelivraison, int quantite_accepte);
    
    List<Ligne_livraison> getLignesLivraison(String query, ArrayList<Parametre> params) throws Exception;
    
}
