/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Nawar
 */
@Entity
public class LigneCommande implements Serializable {

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
        if (!(object instanceof LigneCommande)) {
            return false;
        }
        LigneCommande other = (LigneCommande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.LigneCommande[ id=" + id + " ]";
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
        private Article article;

    /**
     * Get the value of article
     *
     * @return the value of article
     */
    public Article getArticle() {
        return article;
    }

    /**
     * Set the value of article
     *
     * @param article new value of article
     */
    public void setArticle(Article article) {
        this.article = article;
    }

    private int quantite;

    /**
     * Get the value of quantite
     *
     * @return the value of quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Set the value of quantite
     *
     * @param quantite new value of quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    
        private float prix_achat;

    /**
     * Get the value of prix_achat
     *
     * @return the value of prix_achat
     */
    public float getPrix_achat() {
        return prix_achat;
    }

    /**
     * Set the value of prix_achat
     *
     * @param prix_achat new value of prix_achat
     */
    public void setPrix_achat(float prix_achat) {
        this.prix_achat = prix_achat;
    }

    

}
