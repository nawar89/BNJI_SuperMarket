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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Nawar
 */
@Entity
public class ArticleMagasin implements Serializable {

    @OneToMany(mappedBy = "articleMagasin")
    private List<ligneCommandeCaisse> ligneCommandeCaisses;

    @OneToMany(mappedBy = "articleMagasin")
    private List<ligneCommandeEnLigne> ligneCommandeEnLignes;

    @OneToMany(mappedBy = "articleMagasin")
    private List<Lot> lots;

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
        if (!(object instanceof ArticleMagasin)) {
            return false;
        }
        ArticleMagasin other = (ArticleMagasin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.ArticleMagasin[ id=" + id + " ]";
    }
    
    @ManyToOne
        private Magasin magasin;

    /**
     * Get the value of magasin
     *
     * @return the value of magasin
     */
    public Magasin getMagasin() {
        return magasin;
    }

    /**
     * Set the value of magasin
     *
     * @param magasin new value of magasin
     */
    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
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
    
        private int quantite;

    /**
     * Get the value of quantite
     *
     * @return the value of quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Set the value of quantite
     *
     * @param quantite new value of quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

        private float prix_vente_actuel;

    /**
     * Get the value of prix_vente_actuel
     *
     * @return the value of prix_vente_actuel
     */
    public float getPrix_vente_actuel() {
        return prix_vente_actuel;
    }

    /**
     * Set the value of prix_vente_actuel
     *
     * @param prix_vente_actuel new value of prix_vente_actuel
     */
    public void setPrix_vente_actuel(float prix_vente_actuel) {
        this.prix_vente_actuel = prix_vente_actuel;
    }


    
}
