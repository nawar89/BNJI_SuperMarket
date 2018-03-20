/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Ligne_livraison;
import EntityBean.Reclamation;
import EntityBean.Type_Reclamation;
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
public interface ReclamationFacadeLocal {

    void create(Reclamation reclamation);

    void edit(Reclamation reclamation);

    void remove(Reclamation reclamation);

    Reclamation find(Object id);

    List<Reclamation> findAll();

    List<Reclamation> findRange(int[] range);

    int count();

    void creerReclamation(String rec, Type_Reclamation type, Ligne_livraison ligne,Date dateRec);
    
    List<Reclamation> getReclamations(String query, ArrayList<Parametre> params) throws Exception;
    
}
