/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Article;
import EntityBean.BonCommande;
import EntityBean.LigneCommande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nawar
 */
@Local
public interface LigneCommandeFacadeLocal {

    void create(LigneCommande ligneCommande);

    void edit(LigneCommande ligneCommande);

    void remove(LigneCommande ligneCommande);

    LigneCommande find(Object id);

    List<LigneCommande> findAll();

    List<LigneCommande> findRange(int[] range);

    int count();

    void creerLigneCommande(BonCommande command, Article article, int quantite, float prix);
    
}
