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

/**
 *
 * @author Nawar
 */
@Entity
public class Promotion implements Serializable {

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
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.Promotion[ id=" + id + " ]";
    }
    
        private Date date_debut;

    /**
     * Get the value of date_debut
     *
     * @return the value of date_debut
     */
    public Date getDate_debut() {
        return date_debut;
    }

    /**
     * Set the value of date_debut
     *
     * @param date_debut new value of date_debut
     */
    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    
        private Date date_fin;

    /**
     * Get the value of date_fin
     *
     * @return the value of date_fin
     */
    public Date getDate_fin() {
        return date_fin;
    }

    /**
     * Set the value of date_fin
     *
     * @param date_fin new value of date_fin
     */
    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    
        private float prix_prmotion;

    /**
     * Get the value of prix_prmotion
     *
     * @return the value of prix_prmotion
     */
    public float getPrix_prmotion() {
        return prix_prmotion;
    }

    /**
     * Set the value of prix_prmotion
     *
     * @param prix_prmotion new value of prix_prmotion
     */
    public void setPrix_prmotion(float prix_prmotion) {
        this.prix_prmotion = prix_prmotion;
    }

    
    @ManyToOne
        private Employe directionNationale;

    /**
     * Get the value of directionNationale
     *
     * @return the value of directionNationale
     */
    public Employe getDirectionNationale() {
        return directionNationale;
    }

    /**
     * Set the value of directionNationale
     *
     * @param directionNationale new value of directionNationale
     */
    public void setDirectionNationale(Employe directionNationale) {
        this.directionNationale = directionNationale;
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

    
}
