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
public class Session implements Serializable {

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
        if (!(object instanceof Session)) {
            return false;
        }
        Session other = (Session) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.Session[ id=" + id + " ]";
    }
    
    @ManyToOne
        private Employe employe;

    /**
     * Get the value of employe
     *
     * @return the value of employe
     */
    public Employe getEmploye() {
        return employe;
    }

    /**
     * Set the value of employe
     *
     * @param employe new value of employe
     */
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

        private Date date_debut_session;

    /**
     * Get the value of date_debut_session
     *
     * @return the value of date_debut_session
     */
    public Date getDate_debut_session() {
        return date_debut_session;
    }

    /**
     * Set the value of date_debut_session
     *
     * @param date_debut_session new value of date_debut_session
     */
    public void setDate_debut_session(Date date_debut_session) {
        this.date_debut_session = date_debut_session;
    }

    private Date date_fin_session;

    /**
     * Get the value of date_fin_session
     *
     * @return the value of date_fin_session
     */
    public Date getDate_fin_session() {
        return date_fin_session;
    }

    /**
     * Set the value of date_fin_session
     *
     * @param date_fin_session new value of date_fin_session
     */
    public void setDate_fin_session(Date date_fin_session) {
        this.date_fin_session = date_fin_session;
    }

    
}
