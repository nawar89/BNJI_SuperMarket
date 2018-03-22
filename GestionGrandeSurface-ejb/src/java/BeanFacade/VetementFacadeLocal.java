/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Fournisseur;
import EntityBean.SousCategorie;
import EntityBean.Vetement;
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
public interface VetementFacadeLocal {

    void create(Vetement vetement);

    void edit(Vetement vetement);

    void remove(Vetement vetement);

    Vetement find(Object id);

    List<Vetement> findAll();

    List<Vetement> findRange(int[] range);

    int count();
    void creerVetement(String libelle, String reference, float prix_achat_actuel, Date date_de_creation, String description, SousCategorie sous_categorie, Fournisseur fournisseur,String img ,String taille,String coloris) throws Exception;
    List<Vetement> getVetement(String query, ArrayList<Parametre> params) throws Exception;
}
