/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Role;
import Structure.Aide;
import Structure.Parametre;
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
public class RoleFacade extends AbstractFacade<Role> implements RoleFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoleFacade() {
        super(Role.class);
    }

    
    ////Chercher les roles par query
    @Override
    public List<Role> getRoles(String query, List<Parametre> params) throws Exception{
        List<Role> roles = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            roles = q.getResultList();
            
        }catch(Exception exe){throw exe;}
        return roles;
    }

  
}
