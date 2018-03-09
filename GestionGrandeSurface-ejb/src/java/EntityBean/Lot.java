/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Nawar
 */
@Entity
public class Lot implements Serializable {

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
        if (!(object instanceof Lot)) {
            return false;
        }
        Lot other = (Lot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.Lot[ id=" + id + " ]";
    }
    
      
    @Temporal(javax.persistence.TemporalType.DATE)
        private Date date_promption;

    /**
     * Get the value of date_promption
     *
     * @return the value of date_promption
     */
    public Date getDate_promption() {
        return date_promption;
    }

    /**
     * Set the value of date_promption
     *
     * @param date_promption new value of date_promption
     */
    public void setDate_promption(Date date_promption) {
        this.date_promption = date_promption;
    }

        private int quantite_de_lot;

    /**
     * Get the value of quantite_de_lot
     *
     * @return the value of quantite_de_lot
     */
    public int getQuantite_de_lot() {
        return quantite_de_lot;
    }

    /**
     * Set the value of quantite_de_lot
     *
     * @param quantite_de_lot new value of quantite_de_lot
     */
    public void setQuantite_de_lot(int quantite_de_lot) {
        this.quantite_de_lot = quantite_de_lot;
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


    
}
