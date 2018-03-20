/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.ArticleMagasin;
import EntityBean.Casse;
import EntityBean.Ligne_Casse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author i.silvestre
 */
@Local
public interface Ligne_CasseFacadeLocal {

    void create(Ligne_Casse ligne_Casse);

    void edit(Ligne_Casse ligne_Casse);

    void remove(Ligne_Casse ligne_Casse);

    Ligne_Casse find(Object id);

    List<Ligne_Casse> findAll();

    List<Ligne_Casse> findRange(int[] range);

    int count();

    Ligne_Casse creerLigneCasse(Casse casse, ArticleMagasin articleMag, int quantite);
    
}
