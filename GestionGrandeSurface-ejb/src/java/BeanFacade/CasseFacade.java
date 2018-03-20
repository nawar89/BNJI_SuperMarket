/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Casse;
import EntityBean.Employe;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author i.silvestre
 */
@Stateless
public class CasseFacade extends AbstractFacade<Casse> implements CasseFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CasseFacade() {
        super(Casse.class);
    }

    @Override
    public Casse creerCasse(Employe agentRayon, Date dateCasse) {
        try {
        Casse casse = new Casse();
        casse.setAgentRayon(agentRayon);
        casse.setDate_casse(dateCasse);
        em.persist(casse); 
        return casse;
    } catch(Exception exe){throw exe;}
    }
    
    
    
}
