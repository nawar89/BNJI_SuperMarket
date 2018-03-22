/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.CommandeClientEnLigne;
import EntityBean.Livraison_Client;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nawar
 */
@Local
public interface Livraison_ClientFacadeLocal {

    void create(Livraison_Client livraison_Client);

    void edit(Livraison_Client livraison_Client);

    void remove(Livraison_Client livraison_Client);

    Livraison_Client find(Object id);

    List<Livraison_Client> findAll();

    List<Livraison_Client> findRange(int[] range);

    int count();

    Livraison_Client creerLivraisonClient(Date dateLiv, Date datePrevu, CommandeClientEnLigne commande);
    
}
