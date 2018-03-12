/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.ChefRyon_Categorie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author i.silvestre
 */
@Local
public interface ChefRyon_CategorieFacadeLocal {

    void create(ChefRyon_Categorie chefRyon_Categorie);

    void edit(ChefRyon_Categorie chefRyon_Categorie);

    void remove(ChefRyon_Categorie chefRyon_Categorie);

    ChefRyon_Categorie find(Object id);

    List<ChefRyon_Categorie> findAll();

    List<ChefRyon_Categorie> findRange(int[] range);

    int count();
    
}
