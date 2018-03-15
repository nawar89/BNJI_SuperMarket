/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Categorie;
import EntityBean.SousCategorie;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nawar
 */
@Local
public interface SousCategorieFacadeLocal {

    void create(SousCategorie sousCategorie);

    void edit(SousCategorie sousCategorie);

    void remove(SousCategorie sousCategorie);

    SousCategorie find(Object id);

    List<SousCategorie> findAll();

    List<SousCategorie> findRange(int[] range);

    int count();

    void creerSousCategorie(String libelle, Categorie categorie);
    List<SousCategorie> getSousCategories(String query, ArrayList<Parametre> params) throws Exception;
}
