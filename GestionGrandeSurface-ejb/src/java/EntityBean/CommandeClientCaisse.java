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
public class CommandeClientCaisse implements Serializable {

    @OneToMany(mappedBy = "commandeCaisse")
    private List<ligneCommandeCaisse> ligneCommandeCaisses;

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
        if (!(object instanceof CommandeClientCaisse)) {
            return false;
        }
        CommandeClientCaisse other = (CommandeClientCaisse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.CommandeClientCaisse[ id=" + id + " ]";
    }
    
    @ManyToOne
        private Employe employeCaisse;

    /**
     * Get the value of employeCaisse
     *
     * @return the value of employeCaisse
     */
    public Employe getEmployeCaisse() {
        return employeCaisse;
    }

    /**
     * Set the value of employeCaisse
     *
     * @param employeCaisse new value of employeCaisse
     */
    public void setEmployeCaisse(Employe employeCaisse) {
        this.employeCaisse = employeCaisse;
    }
    
    @ManyToOne
        private Client client;

    /**
     * Get the value of client
     *
     * @return the value of client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Set the value of client
     *
     * @param client new value of client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_commande_client;

    /**
     * Get the value of date_commande_client
     *
     * @return the value of date_commande_client
     */
    public Date getDate_commande_client() {
        return date_commande_client;
    }

    /**
     * Set the value of date_commande_client
     *
     * @param date_commande_client new value of date_commande_client
     */
    public void setDate_commande_client(Date date_commande_client) {
        this.date_commande_client = date_commande_client;
    }


    
}
