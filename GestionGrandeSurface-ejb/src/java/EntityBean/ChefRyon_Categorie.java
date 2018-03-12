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
public class ChefRyon_Categorie implements Serializable {

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
        if (!(object instanceof ChefRyon_Categorie)) {
            return false;
        }
        ChefRyon_Categorie other = (ChefRyon_Categorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.ChefRyon_Categorie[ id=" + id + " ]";
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
        private Categorie categorie;

    /**
     * Get the value of categorie
     *
     * @return the value of categorie
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Set the value of categorie
     *
     * @param categorie new value of categorie
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    
}
