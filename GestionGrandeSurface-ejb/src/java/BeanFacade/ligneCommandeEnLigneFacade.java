/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanFacade;

import EntityBean.ArticleMagasin;
import EntityBean.CommandeClientEnLigne;
import EntityBean.ligneCommandeEnLigne;
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
public class ligneCommandeEnLigneFacade extends AbstractFacade<ligneCommandeEnLigne> implements ligneCommandeEnLigneFacadeLocal {

    @PersistenceContext(unitName = "GestionGrandeSurface-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ligneCommandeEnLigneFacade() {
        super(ligneCommandeEnLigne.class);
    }

    @Override
    public ligneCommandeEnLigne creerLigneCommandeEnligne(CommandeClientEnLigne commande, ArticleMagasin article, int quantite,float prix,boolean promo) {
        ligneCommandeEnLigne l = new ligneCommandeEnLigne();
        l.setArticleMagasin(article);
        l.setCommandeClient(commande);
        l.setQuantite(quantite);
        l.setPrix_vente(prix);
        l.setEnPromo(promo);
        em.persist(l);
        return l;
    }

    @Override
    public void modifierLigneCommandeEnLigne(ligneCommandeEnLigne ligne, int quantite) {
        ligne.setQuantite(quantite);
        em.merge(ligne);
    }

    @Override
    public void supprimerLigneCommandeEnLigne(ligneCommandeEnLigne ligne) {
        em.remove(ligne);
    }
    
      @Override
    public List<ligneCommandeEnLigne> getLigneCommandeEnligne(String query, ArrayList<Parametre> params) throws Exception{
        List<ligneCommandeEnLigne> listeLigne = null;
        try{
         
            Query q = em.createQuery(query);
            if (params !=null){
                for (Parametre p : params){
                    Aide.Casting(p.type,p.valeur);
                    q.setParameter(p.nom,p.valeur );
                }
            }
            listeLigne = q.getResultList();
        }catch(Exception exe){
            //throw exe;
        }
        return listeLigne;
    }

    
    
    
    
    
}
