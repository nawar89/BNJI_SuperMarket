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

/**
 *
 * @author i.silvestre
 */
@Entity
public class Casse implements Serializable {

    @OneToMany(mappedBy = "casse")
    private List<Ligne_Casse> ligne_Casses;

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
        if (!(object instanceof Casse)) {
            return false;
        }
        Casse other = (Casse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.Casse[ id=" + id + " ]";
    }
    private Date date_casse ; 

    public List<Ligne_Casse> getLigne_Casses() {
        return ligne_Casses;
    }

    public void setLigne_Casses(List<Ligne_Casse> ligne_Casses) {
        this.ligne_Casses = ligne_Casses;
    }

    public Date getDate_casse() {
        return date_casse;
    }

    public void setDate_casse(Date date_casse) {
        this.date_casse = date_casse;
    }
    @ManyToOne
    private Employe agentRayon ;

    public Employe getAgentRayon() {
        return agentRayon;
    }

    public void setAgentRayon(Employe agentRayon) {
        this.agentRayon = agentRayon;
    }
    
}
