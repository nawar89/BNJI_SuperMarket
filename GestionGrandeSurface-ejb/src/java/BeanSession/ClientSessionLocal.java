/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSession;

import EntityBean.ArticleMagasin;
import EntityBean.Client;
import EntityBean.CommandeClientEnLigne;
import EntityBean.Etat_Commande;
import EntityBean.Livraison_Client;
import EntityBean.Magasin;
import EntityBean.ligneCommandeEnLigne;
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
public interface ClientSessionLocal {
    Client creerClient(String nom, String prenom, String adresse, String email, String phone, String login, String mdp,Date datenaissance,boolean actif);
    
    List<Client> getClients(String query, ArrayList<Parametre> params) throws Exception;
    
    CommandeClientEnLigne creerCommandeEnligne(Date date, Etat_Commande etat, Client client) ;
    
    List<CommandeClientEnLigne> getCommandeEnligne(String query, ArrayList<Parametre> params) throws Exception;
    
    ligneCommandeEnLigne creerLigneCommandeEnligne(CommandeClientEnLigne commande, ArticleMagasin article, int quantite,float prix,boolean promo);
    
    Livraison_Client creerLivraisonClient(Date dateLiv, Date datePrevu, CommandeClientEnLigne commande);
    
    List<Magasin> getMagasins(String query, ArrayList<Parametre> params) throws Exception;
    
    
    
}
