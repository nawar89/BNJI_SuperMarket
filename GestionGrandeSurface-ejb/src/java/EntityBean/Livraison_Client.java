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
public class Livraison_Client implements Serializable {

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
        if (!(object instanceof Livraison_Client)) {
            return false;
        }
        Livraison_Client other = (Livraison_Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.Livraison_Client[ id=" + id + " ]";
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

    
    @Temporal(javax.persistence.TemporalType.DATE)
        private Date date_prevu;

    /**
     * Get the value of date_prevu
     *
     * @return the value of date_prevu
     */
    public Date getDate_prevu() {
        return date_prevu;
    }

    /**
     * Set the value of date_prevu
     *
     * @param date_prevu new value of date_prevu
     */
    public void setDate_prevu(Date date_prevu) {
        this.date_prevu = date_prevu;
    }

    @ManyToOne
        private CommandeClientEnLigne commandeClient;

    /**
     * Get the value of commandeClient
     *
     * @return the value of commandeClient
     */
    public CommandeClientEnLigne getCommandeClient() {
        return commandeClient;
    }

    /**
     * Set the value of commandeClient
     *
     * @param commandeClient new value of commandeClient
     */
    public void setCommandeClient(CommandeClientEnLigne commandeClient) {
        this.commandeClient = commandeClient;
    }

}
