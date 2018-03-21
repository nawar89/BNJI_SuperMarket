/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.ArticleMagasin;
import EntityBean.Lot;
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
public interface LotFacadeLocal {

    void create(Lot lot);

    void edit(Lot lot);

    void remove(Lot lot);

    Lot find(Object id);

    List<Lot> findAll();

    List<Lot> findRange(int[] range);

    int count();

    void creerLot(Date date_de_peremption, int quantite, ArticleMagasin article);
    
    List<Lot> getLots(String query, ArrayList<Parametre> params) throws Exception;

    void ajouterQuantiteLot(Lot lot, int quantite);
    
    void enleverQuantiteLot(Lot lot, int quantite);
    
    
}
