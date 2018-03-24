/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Client;
import EntityBean.CommandeClientEnLigne;
import EntityBean.Etat_Commande;
import Structure.Aide;
import Structure.Parametre;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nawar
 */
@Stateless
public class CommandeClientEnLigneFacade extends AbstractFacade<CommandeClientEnLigne> implements CommandeClientEnLigneFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeClientEnLigneFacade() {
        super(CommandeClientEnLigne.class);
    }

    @Override
    public CommandeClientEnLigne creerCommandeEnligne(Date date, Etat_Commande etat, Client client) {
        CommandeClientEnLigne c = new CommandeClientEnLigne();
        c.setClient(client);
        c.setEtat(etat);
        c.setDate_commande_client(date);
        em.persist(c);
        return c;
    }
    
       @Override
    public List<CommandeClientEnLigne> getCommandeEnligne(String query, ArrayList<Parametre> params) throws Exception{
        List<CommandeClientEnLigne> listeComs = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            listeComs = q.getResultList();
        }catch(Exception exe){
            //throw exe;
        }
        return listeComs;
    }

    @Override
    public void supprimerCommandeEnLigne(CommandeClientEnLigne commande) {
        em.remove(commande);
    }
    
    
    
    

    
    
    
}
