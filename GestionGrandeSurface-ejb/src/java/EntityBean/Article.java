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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Nawar
 */
@Entity
@Inheritance (strategy=InheritanceType.JOINED)
public class Article implements Serializable {

    @OneToMany(mappedBy = "article")
    private List<Ligne_livraison> ligne_livraisons;

    @OneToMany(mappedBy = "article")
    private List<LigneCommande> ligneCommandes;

    @OneToMany(mappedBy = "article")
    private List<Promotion> promotions;

    @OneToMany(mappedBy = "article")
    private List<ArticleMagasin> articleMagasins;

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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.Article[ id=" + id + " ]";
    }
    
        private String libelle;

    /**
     * Get the value of libelle
     *
     * @return the value of libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Set the value of libelle
     *
     * @param libelle new value of libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    
        private String reference;

    /**
     * Get the value of reference
     *
     * @return the value of reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * Set the value of reference
     *
     * @param reference new value of reference
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    
        private float prix_achat_actuel;

    /**
     * Get the value of prix_achat_actuel
     *
     * @return the value of prix_achat_actuel
     */
    public float getPrix_achat_actuel() {
        return prix_achat_actuel;
    }

    /**
     * Set the value of prix_achat_actuel
     *
     * @param prix_achat_actuel new value of prix_achat_actuel
     */
    public void setPrix_achat_actuel(float prix_achat_actuel) {
        this.prix_achat_actuel = prix_achat_actuel;
    }

  
    
    @Temporal(javax.persistence.TemporalType.DATE)
        private Date date_creation;

    /**
     * Get the value of date_creation
     *
     * @return the value of date_creation
     */
    public Date getDate_creation() {
        return date_creation;
    }

    /**
     * Set the value of date_creation
     *
     * @param date_creation new value of date_creation
     */
    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    
        private String description;

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    
   }
    
    @ManyToOne
       private SousCategorie sousCategorie;

    /**
     * Get the value of sousCategorie
     *
     * @return the value of sousCategorie
     */
    public SousCategorie getSousCategorie() {
        return sousCategorie;
    }

    /**
     * Set the value of sousCategorie
     *
     * @param sousCategorie new value of sousCategorie
     */
    public void setSousCategorie(SousCategorie sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    @ManyToOne
    private Fournisseur fournisseur;

    /**
     * Get the value of fournisseur
     *
     * @return the value of fournisseur
     */
    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    /**
     * Set the value of fournisseur
     *
     * @param fournisseur new value of fournisseur
     */
    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    
}
