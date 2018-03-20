/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Lot;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author i.silvestre
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

    void modifierQuantiteLot(int quantite, Lot lot);
    
    public List<Lot> getLot(String query, ArrayList<Parametre> params) throws Exception ; 
    
    
}
