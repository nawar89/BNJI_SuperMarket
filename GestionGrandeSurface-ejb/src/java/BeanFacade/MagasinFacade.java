/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.Magasin;
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
public class MagasinFacade extends AbstractFacade<Magasin> implements MagasinFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MagasinFacade() {
        super(Magasin.class);
    }

    @Override
    public void creerMagasin(String adresse, String nom, String code, String ville,String horaireOuverture,String horaireFermeture,String gps) {
        Magasin m = new Magasin();
        m.setAdresse(adresse);
        m.setNom(nom);
        m.setCode_postal(code);
        m.setVille(ville);
        m.setHoraire_fermeture(horaireFermeture);
        m.setHoraire_ouverteur(horaireOuverture);
        m.setGps(gps);
        em.persist(m);
    }
    
     @Override
    public List<Magasin> getMagasins(String query, ArrayList<Parametre> params) throws Exception{
        List<Magasin> magasins = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            magasins = q.getResultList();
        }catch(Exception exe){throw exe;}
        return magasins;
    }

    @Override
    public void modifierMagasin(String nom, String adresse, String ville, String code, String horaire_ouver, String horaire_ferm, String gps, Magasin magasin) {
        magasin.setNom(nom);
        magasin.setAdresse(adresse);
        magasin.setVille(ville);
        magasin.setCode_postal(code);
        magasin.setGps(gps);
        magasin.setHoraire_fermeture(horaire_ferm);
        magasin.setHoraire_ouverteur(horaire_ouver);
        em.merge(magasin);
    }
    
    
    
}
