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
public class Ligne_livraison implements Serializable {

    @OneToMany(mappedBy = "ligneLivraison")
    private List<Reclamation> reclamations;

    public List<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(List<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

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
        if (!(object instanceof Ligne_livraison)) {
            return false;
        }
        Ligne_livraison other = (Ligne_livraison) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.Ligne_livraison[ id=" + id + " ]";
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

    @ManyToOne
        private Livraison livraison;

    /**
     * Get the value of livraison
     *
     * @return the value of livraison
     */
    public Livraison getLivraison() {
        return livraison;
    }

    /**
     * Set the value of livraison
     *
     * @param livraison new value of livraison
     */
    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }

    private int quantite_livree;

    /**
     * Get the value of quantite_livree
     *
     * @return the value of quantite_livree
     */
    public int getQuantite_livree() {
        return quantite_livree;
    }

    /**
     * Set the value of quantite_livree
     *
     * @param quantite_livree new value of quantite_livree
     */
    public void setQuantite_livree(int quantite_livree) {
        this.quantite_livree = quantite_livree;
    }

    
}
