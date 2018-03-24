/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSession;

import BeanFacade.ArticleFacadeLocal;
import BeanFacade.ClientFacadeLocal;
import BeanFacade.CommandeClientEnLigneFacade;
import BeanFacade.CommandeClientEnLigneFacadeLocal;
import BeanFacade.Livraison_ClientFacadeLocal;
import BeanFacade.MagasinFacadeLocal;
import BeanFacade.ligneCommandeEnLigneFacadeLocal;
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
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nawar
 */
@Stateless
public class ClientSession implements ClientSessionLocal {

    @EJB
    private Livraison_ClientFacadeLocal livraison_ClientFacade;

    @EJB
    private ligneCommandeEnLigneFacadeLocal ligneCommandeEnLigneFacade;

    @EJB
    private CommandeClientEnLigneFacadeLocal commandeClientEnLigneFacade;

    @EJB
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private ArticleFacadeLocal articleFacade;

    @EJB
    private ClientFacadeLocal clientFacade;
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @Override
    public Client creerClient(String nom, String prenom, String adresse, String email, String phone, String login, String mdp,Date datenaissance,boolean actif) {
        return clientFacade.creerClient(nom, prenom, adresse, email, phone, login, mdp, datenaissance, actif);
    }
    
      @Override
    public List<Client> getClients(String query, ArrayList<Parametre> params) throws Exception{
        return clientFacade.getClients(query, params);
    }
    
    @Override
    public CommandeClientEnLigne creerCommandeEnligne(Date date, Etat_Commande etat, Client client) {
        return commandeClientEnLigneFacade.creerCommandeEnligne(date, etat, client);
    }
    
     @Override
    public List<CommandeClientEnLigne> getCommandeEnligne(String query, ArrayList<Parametre> params) throws Exception{
        return commandeClientEnLigneFacade.getCommandeEnligne(query, params);
    }
    
    @Override
    public ligneCommandeEnLigne creerLigneCommandeEnligne(CommandeClientEnLigne commande, ArticleMagasin article, int quantite,float prix,boolean promo){
        return ligneCommandeEnLigneFacade.creerLigneCommandeEnligne(commande, article, quantite, prix, promo);
    }
    
    @Override
    public Livraison_Client creerLivraisonClient(Date dateLiv, Date datePrevu, CommandeClientEnLigne commande) {
        return livraison_ClientFacade.creerLivraisonClient(dateLiv, datePrevu, commande);
    }
    
       @Override
    public List<Magasin> getMagasins(String query, ArrayList<Parametre> params) throws Exception{
        return magasinFacade.getMagasins(query, params);
    }
    @Override
    public void modifierLigneCommandeEnLigne(ligneCommandeEnLigne ligne, int quantite) {
        ligneCommandeEnLigneFacade.modifierLigneCommandeEnLigne(ligne, quantite);
    }
    
    @Override
    public void supprimerLigneCommandeEnLigne(ligneCommandeEnLigne ligne) {
        ligneCommandeEnLigneFacade.supprimerLigneCommandeEnLigne(ligne);
    }
    
    @Override
    public void supprimerCommandeEnLigne(CommandeClientEnLigne commande) {
        commandeClientEnLigneFacade.supprimerCommandeEnLigne(commande);
    }
    @Override
    public List<ligneCommandeEnLigne> getLigneCommandeEnligne(String query, ArrayList<Parametre> params) throws Exception{
        return ligneCommandeEnLigneFacade.getLigneCommandeEnligne(query, params);
    }
    
}
