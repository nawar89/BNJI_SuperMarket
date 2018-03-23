/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Client;
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
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public Client creerClient(String nom, String prenom, String adresse, String email, String phone, String login, String mdp,Date datenaissance,boolean actif) {
        Client c = new Client();
        c.setActif(actif);
        c.setNom(nom);
        c.setPrenom(prenom);
        c.setAdresse(adresse);
        c.setTelephone(phone);
        c.setEmail(email);
        c.setLogin(login);
        c.setMdp(mdp);
        em.persist(c);
        return c;
    }
    
      @Override
    public List<Client> getClients(String query, ArrayList<Parametre> params) throws Exception{
        List<Client> lots = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            lots = q.getResultList();
        }catch(Exception exe){
            //throw exe;
        }
        return lots;
    }
    
    

    
    
    
}
