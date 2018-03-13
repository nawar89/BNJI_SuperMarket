/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Magasin;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nawar
 */
@Local
public interface MagasinFacadeLocal {

    void create(Magasin magasin);

    void edit(Magasin magasin);

    void remove(Magasin magasin);

    Magasin find(Object id);

    List<Magasin> findAll();

    List<Magasin> findRange(int[] range);

    int count();

    void creerMagasin(String adresse, String nom, String code, String ville,String horaireOuverture,String horaireFermeture,String gps);
    
    List<Magasin> getMagasins(String query, ArrayList<Parametre> params) throws Exception;
    
}
