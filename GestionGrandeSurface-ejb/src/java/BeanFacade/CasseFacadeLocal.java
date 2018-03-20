/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Casse;
import EntityBean.Employe;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author i.silvestre
 */
@Local
public interface CasseFacadeLocal {

    void create(Casse casse);

    void edit(Casse casse);

    void remove(Casse casse);

    Casse find(Object id);

    List<Casse> findAll();

    List<Casse> findRange(int[] range);

    int count();

    Casse creerCasse(Employe agentRayon, Date dateCasse);
    
    List<Casse> getCasses(String query, ArrayList<Parametre> params) throws Exception ;
    
}
