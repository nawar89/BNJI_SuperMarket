/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Nawar 
 */
@Entity
public class Magasin implements Serializable {

    @OneToMany(mappedBy = "magasin")
    private List<ArticleMagasin> articleMagasins;

    public List<ArticleMagasin> getArticleMagasins() {
        return articleMagasins;
    }

    public void setArticleMagasins(List<ArticleMagasin> articleMagasins) {
        this.articleMagasins = articleMagasins;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    @OneToMany(mappedBy = "magasin")
    private List<Employe> employes;

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
        if (!(object instanceof Magasin)) {
            return false;
        }
        Magasin other = (Magasin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.Magasin[ id=" + id + " ]";
    }
    
    private String nom;

    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

        private String adresse;

    /**
     * Get the value of adresse
     *
     * @return the value of adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Set the value of adresse
     *
     * @param adresse new value of adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    
        private String gps;

    /**
     * Get the value of gps
     *
     * @return the value of gps
     */
    public String getGps() {
        return gps;
    }

    /**
     * Set the value of gps
     *
     * @param gps new value of gps
     */
    public void setGps(String gps) {
        this.gps = gps;
    }

    
        private String horaire_ouverteur;

    /**
     * Get the value of horaire_ouverteur
     *
     * @return the value of horaire_ouverteur
     */
    public String getHoraire_ouverteur() {
        return horaire_ouverteur;
    }

    /**
     * Set the value of horaire_ouverteur
     *
     * @param horaire_ouverteur new value of horaire_ouverteur
     */
    public void setHoraire_ouverteur(String horaire_ouverteur) {
        this.horaire_ouverteur = horaire_ouverteur;
    }

    
        private String horaire_fermeture;

    /**
     * Get the value of horaire_fermeture
     *
     * @return the value of horaire_fermeture
     */
    public String getHoraire_fermeture() {
        return horaire_fermeture;
    }

    /**
     * Set the value of horaire_fermeture
     *
     * @param horaire_fermeture new value of horaire_fermeture
     */
    public void setHoraire_fermeture(String horaire_fermeture) {
        this.horaire_fermeture = horaire_fermeture;
    }

    
        private String code_postal;

    /**
     * Get the value of code_postal
     *
     * @return the value of code_postal
     */
    public String getCode_postal() {
        return code_postal;
    }

    /**
     * Set the value of code_postal
     *
     * @param code_postal new value of code_postal
     */
    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    
        private String ville;

    /**
     * Get the value of ville
     *
     * @return the value of ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * Set the value of ville
     *
     * @param ville new value of ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    
}
