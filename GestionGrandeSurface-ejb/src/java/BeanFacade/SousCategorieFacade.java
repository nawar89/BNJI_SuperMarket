/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Categorie;
import EntityBean.SousCategorie;
import Structure.Aide;
import Structure.Parametre;
import java.util.ArrayList;
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
public class SousCategorieFacade extends AbstractFacade<SousCategorie> implements SousCategorieFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SousCategorieFacade() {
        super(SousCategorie.class);
    }

    @Override
    public void creerSousCategorie(String libelle, Categorie categorie) {
        SousCategorie s = new SousCategorie();
        s.setLibelle(libelle);
        s.setCategorie(categorie);
        em.persist(s);
    }
    
    @Override
    public List<SousCategorie> getSousCategories(String query, ArrayList<Parametre> params) throws Exception{
        List<SousCategorie> cats = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            cats = q.getResultList();
        }catch(Exception exe){
            //throw exe;
        }
        return cats;
    }
    
    
    
}
