/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Article;
import EntityBean.ArticleMagasin;
import EntityBean.Magasin;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jihane
 */
@Local
public interface ArticleMagasinFacadeLocal {

    void create(ArticleMagasin articleMagasin);

    void edit(ArticleMagasin articleMagasin);

    void remove(ArticleMagasin articleMagasin);

    ArticleMagasin find(Object id);

    List<ArticleMagasin> findAll();

    List<ArticleMagasin> findRange(int[] range);

    int count();

    void creerArticleMag(int quantite, float prix_vente_actuel, Article article, Magasin magasin)throws Exception;
    List<ArticleMagasin> getArticleMagasin(String query, ArrayList<Parametre> params) throws Exception;

    void modifierPrixVente(ArticleMagasin articleMagasin, float nouveauPrix);
    
    void ajouterQuantite(ArticleMagasin articleMagasin, int quantite) ;
    
    void enleverQuantite(ArticleMagasin articleMagasin, int quantite);
}
