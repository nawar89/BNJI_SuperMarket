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

/**
 *
 * @author Nawar
 */
@Entity
public class Vetement extends Article implements Serializable {

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
        if (!(object instanceof Vetement)) {
            return false;
        }
        Vetement other = (Vetement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.Vetement[ id=" + id + " ]";
    }
    
    
        private String taille;

    /**
     * Get the value of taille
     *
     * @return the value of taille
     */
    public String getTaille() {
        return taille;
    }

    /**
     * Set the value of taille
     *
     * @param taille new value of taille
     */
    public void setTaille(String taille) {
        this.taille = taille;
    }

    
        private String coloris;

    /**
     * Get the value of coloris
     *
     * @return the value of coloris
     */
    public String getColoris() {
        return coloris;
    }

    /**
     * Set the value of coloris
     *
     * @param coloris new value of coloris
     */
    public void setColoris(String coloris) {
        this.coloris = coloris;
    }

    
}
