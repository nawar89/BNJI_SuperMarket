/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Client;
import EntityBean.CommandeClientEnLigne;
import EntityBean.Etat_Commande;
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
public interface CommandeClientEnLigneFacadeLocal {

    void create(CommandeClientEnLigne commandeClientEnLigne);

    void edit(CommandeClientEnLigne commandeClientEnLigne);

    void remove(CommandeClientEnLigne commandeClientEnLigne);

    CommandeClientEnLigne find(Object id);

    List<CommandeClientEnLigne> findAll();

    List<CommandeClientEnLigne> findRange(int[] range);

    int count();

    CommandeClientEnLigne creerCommandeEnligne(Date date, Etat_Commande etat, Client client);
    
     List<CommandeClientEnLigne> getCommandeEnligne(String query, ArrayList<Parametre> params) throws Exception;
     
    
    
}
