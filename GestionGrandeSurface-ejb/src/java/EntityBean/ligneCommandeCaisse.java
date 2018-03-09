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
public class ligneCommandeCaisse implements Serializable {

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
        if (!(object instanceof ligneCommandeCaisse)) {
            return false;
        }
        ligneCommandeCaisse other = (ligneCommandeCaisse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.ligneCommandeCaisse[ id=" + id + " ]";
    }
    
    @ManyToOne
        private CommandeClientCaisse commandeCaisse;

    /**
     * Get the value of commandeCaisse
     *
     * @return the value of commandeCaisse
     */
    public CommandeClientCaisse getCommandeCaisse() {
        return commandeCaisse;
    }

    /**
     * Set the value of commandeCaisse
     *
     * @param commandeCaisse new value of commandeCaisse
     */
    public void setCommandeCaisse(CommandeClientCaisse commandeCaisse) {
        this.commandeCaisse = commandeCaisse;
    }
    
    @ManyToOne
        private ArticleMagasin articleMagasin;

    /**
     * Get the value of articleMagasin
     *
     * @return the value of articleMagasin
     */
    public ArticleMagasin getArticleMagasin() {
        return articleMagasin;
    }

    /**
     * Set the value of articleMagasin
     *
     * @param articleMagasin new value of articleMagasin
     */
    public void setArticleMagasin(ArticleMagasin articleMagasin) {
        this.articleMagasin = articleMagasin;
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

    private float prix_vente;

    /**
     * Get the value of prix_vente
     *
     * @return the value of prix_vente
     */
    public float getPrix_vente() {
        return prix_vente;
    }

    /**
     * Set the value of prix_vente
     *
     * @param prix_vente new value of prix_vente
     */
    public void setPrix_vente(float prix_vente) {
        this.prix_vente = prix_vente;
    }

    
        private boolean enPromo;

    /**
     * Get the value of enPromo
     *
     * @return the value of enPromo
     */
    public boolean isEnPromo() {
        return enPromo;
    }

    /**
     * Set the value of enPromo
     *
     * @param enPromo new value of enPromo
     */
    public void setEnPromo(boolean enPromo) {
        this.enPromo = enPromo;
    }



    
}
