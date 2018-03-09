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
public class Reclamation implements Serializable {

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
        if (!(object instanceof Reclamation)) {
            return false;
        }
        Reclamation other = (Reclamation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.Reclamation[ id=" + id + " ]";
    }
    
    @ManyToOne
        private Ligne_livraison ligneLivraison;

    /**
     * Get the value of ligneLivraison
     *
     * @return the value of ligneLivraison
     */
    public Ligne_livraison getLigneLivraison() {
        return ligneLivraison;
    }

    /**
     * Set the value of ligneLivraison
     *
     * @param ligneLivraison new value of ligneLivraison
     */
    public void setLigneLivraison(Ligne_livraison ligneLivraison) {
        this.ligneLivraison = ligneLivraison;
    }

         private Type_Reclamation Etat_Reclamation;

    /**
     * Get the value of Etat_Reclamation
     *
     * @return the value of Etat_Reclamation
     */
    public Type_Reclamation getEtat_Reclamation() {
        return Etat_Reclamation;
    }

    /**
     * Set the value of Etat_Reclamation
     *
     * @param Etat_Reclamation new value of Etat_Reclamation
     */
    public void setEtat_Reclamation(Type_Reclamation Etat_Reclamation) {
        this.Etat_Reclamation = Etat_Reclamation;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_reclamation;

    /**
     * Get the value of date_reclamation
     *
     * @return the value of date_reclamation
     */
    public Date getDate_reclamation() {
        return date_reclamation;
    }

    /**
     * Set the value of date_reclamation
     *
     * @param date_reclamation new value of date_reclamation
     */
    public void setDate_reclamation(Date date_reclamation) {
        this.date_reclamation = date_reclamation;
    }

    private String reclamation;

    /**
     * Get the value of reclamation
     *
     * @return the value of reclamation
     */
    public String getReclamation() {
        return reclamation;
    }

    /**
     * Set the value of reclamation
     *
     * @param reclamation new value of reclamation
     */
    public void setReclamation(String reclamation) {
        this.reclamation = reclamation;
    }

    
}
