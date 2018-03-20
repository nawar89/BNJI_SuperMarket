/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Electromenager;
import EntityBean.Fournisseur;
import EntityBean.SousCategorie;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jihane
 */
@Local
public interface ElectromenagerFacadeLocal {

    void create(Electromenager electromenager);

    void edit(Electromenager electromenager);

    void remove(Electromenager electromenager);

    Electromenager find(Object id);

    List<Electromenager> findAll();

    List<Electromenager> findRange(int[] range);

    int count();
    List<Electromenager> getElectro(String query, ArrayList<Parametre> params) throws Exception;
    void creerElec(String libelle, String reference, float prix_achat_actuel, Date date_de_creation, String description, SousCategorie sous_categorie, Fournisseur fournisseur, int period_garantie) throws Exception;
}
