/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Nawar
 */
@Entity
public class BonCommande implements Serializable {

    @OneToMany(mappedBy = "bonCommande")
    private List<Livraison> livraisons;

    @OneToMany(mappedBy = "bonCommande")
    private List<LigneCommande> ligneCommandes;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BonCommande)) {
            return false;
        }
        BonCommande other = (BonCommande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.BonCommande[ id=" + id + " ]";
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
        private Date date_commande;

    /**
     * Get the value of date_commande
     *
     * @return the value of date_commande
     */
    public Date getDate_commande() {
        return date_commande;
    }

    /**
     * Set the value of date_commande
     *
     * @param date_commande new value of date_commande
     */
    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    @ManyToOne
    private Employe chefRyon;

    /**
     * Get the value of chefRyon
     *
     * @return the value of chefRyon
     */
    public Employe getChefRyon() {
        return chefRyon;
    }

    /**
     * Set the value of chefRyon
     *
     * @param chefRyon new value of chefRyon
     */
    public void setChefRyon(Employe chefRyon) {
        this.chefRyon = chefRyon;
    }

    @ManyToOne
        private Fournisseur fournisseur;

    /**
     * Get the value of fournisseur
     *
     * @return the value of fournisseur
     */
    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    /**
     * Set the value of fournisseur
     *
     * @param fournisseur new value of fournisseur
     */
    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

}
