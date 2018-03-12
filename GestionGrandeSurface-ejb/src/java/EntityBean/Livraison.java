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
public class Livraison implements Serializable {

    @OneToMany(mappedBy = "livraison")
    private List<Ligne_livraison> ligne_livraisons;

    public List<Ligne_livraison> getLigne_livraisons() {
        return ligne_livraisons;
    }

    public void setLigne_livraisons(List<Ligne_livraison> ligne_livraisons) {
        this.ligne_livraisons = ligne_livraisons;
    }

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
        if (!(object instanceof Livraison)) {
            return false;
        }
        Livraison other = (Livraison) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.Livraison[ id=" + id + " ]";
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
        private Date date_livraison;

    /**
     * Get the value of date_livraison
     *
     * @return the value of date_livraison
     */
    public Date getDate_livraison() {
        return date_livraison;
    }

    /**
     * Set the value of date_livraison
     *
     * @param date_livraison new value of date_livraison
     */
    public void setDate_livraison(Date date_livraison) {
        this.date_livraison = date_livraison;
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

    @ManyToOne
        private BonCommande bonCommande;

    /**
     * Get the value of bonCommande
     *
     * @return the value of bonCommande
     */
    public BonCommande getBonCommande() {
        return bonCommande;
    }

    /**
     * Set the value of bonCommande
     *
     * @param bonCommande new value of bonCommande
     */
    public void setBonCommande(BonCommande bonCommande) {
        this.bonCommande = bonCommande;
    }

    
    @ManyToOne
        private Employe agentLivraison;

    /**
     * Get the value of agentLivraison
     *
     * @return the value of agentLivraison
     */
    public Employe getAgentLivraison() {
        return agentLivraison;
    }

    /**
     * Set the value of agentLivraison
     *
     * @param agentLivraison new value of agentLivraison
     */
    public void setAgentLivraison(Employe agentLivraison) {
        this.agentLivraison = agentLivraison;
    }

    private Date date_livraison_prevu;

    /**
     * Get the value of date_livraison_prevu
     *
     * @return the value of date_livraison_prevu
     */
    public Date getDate_livraison_prevu() {
        return date_livraison_prevu;
    }

    /**
     * Set the value of date_livraison_prevu
     *
     * @param date_livraison_prevu new value of date_livraison_prevu
     */
    public void setDate_livraison_prevu(Date date_livraison_prevu) {
        this.date_livraison_prevu = date_livraison_prevu;
    }

    private Etat_Livraison mention;

    /**
     * Get the value of mention
     *
     * @return the value of mention
     */
    public Etat_Livraison getMention() {
        return mention;
    }

    /**
     * Set the value of mention
     *
     * @param mention new value of mention
     */
    public void setMention(Etat_Livraison mention) {
        this.mention = mention;
    }

   
}
