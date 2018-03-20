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
public class Employe implements Serializable {

    @OneToMany(mappedBy = "agentRayon")
    private List<Casse> casses;

    public List<Casse> getCasses() {
        return casses;
    }

    public void setCasses(List<Casse> casses) {
        this.casses = casses;
    }

    @OneToMany(mappedBy = "employeCaisse")
    private List<CommandeClientCaisse> commandeClientCaisses;

    public List<CommandeClientCaisse> getCommandeClientCaisses() {
        return commandeClientCaisses;
    }

    public void setCommandeClientCaisses(List<CommandeClientCaisse> commandeClientCaisses) {
        this.commandeClientCaisses = commandeClientCaisses;
    }

    public List<Livraison> getLivraisons() {
        return livraisons;
    }

    public void setLivraisons(List<Livraison> livraisons) {
        this.livraisons = livraisons;
    }

    public List<BonCommande> getBonCommandes() {
        return bonCommandes;
    }

    public void setBonCommandes(List<BonCommande> bonCommandes) {
        this.bonCommandes = bonCommandes;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<ChefRyon_Categorie> getChefRyon_Categories() {
        return chefRyon_Categories;
    }

    public void setChefRyon_Categories(List<ChefRyon_Categorie> chefRyon_Categories) {
        this.chefRyon_Categories = chefRyon_Categories;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    @OneToMany(mappedBy = "agentLivraison")
    private List<Livraison> livraisons;

    @OneToMany(mappedBy = "chefRyon")
    private List<BonCommande> bonCommandes;

    @OneToMany(mappedBy = "employe")
    private List<Session> sessions;

    @OneToMany(mappedBy = "chefRyon")
    private List<ChefRyon_Categorie> chefRyon_Categories;

    @OneToMany(mappedBy = "directionNationale")
    private List<Promotion> promotions;

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
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.Employe[ id=" + id + " ]";
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
    
        private String prenom;

    /**
     * Get the value of prenom
     *
     * @return the value of prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Set the value of prenom
     *
     * @param prenom new value of prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    
        private String telephone;

    /**
     * Get the value of telephone
     *
     * @return the value of telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Set the value of telephone
     *
     * @param telephone new value of telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    
        private String email;

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    private String login;

    /**
     * Get the value of login
     *
     * @return the value of login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Set the value of login
     *
     * @param login new value of login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    private String mdp;

    /**
     * Get the value of mdp
     *
     * @return the value of mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Set the value of mdp
     *
     * @param mdp new value of mdp
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    
        private boolean actif;

    /**
     * Get the value of actif
     *
     * @return the value of actif
     */
    public boolean isActif() {
        return actif;
    }

    /**
     * Set the value of actif
     *
     * @param actif new value of actif
     */
    public void setActif(boolean actif) {
        this.actif = actif;
    }

    
        private boolean bloque;

    /**
     * Get the value of bloque
     *
     * @return the value of bloque
     */
    public boolean isBloque() {
        return bloque;
    }

    /**
     * Set the value of bloque
     *
     * @param bloque new value of bloque
     */
    public void setBloque(boolean bloque) {
        this.bloque = bloque;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_bloque;

    /**
     * Get the value of date_bloque
     *
     * @return the value of date_bloque
     */
    public Date getDate_bloque() {
        return date_bloque;
    }

    /**
     * Set the value of date_bloque
     *
     * @param date_bloque new value of date_bloque
     */
    public void setDate_bloque(Date date_bloque) {
        this.date_bloque = date_bloque;
    }

    @ManyToOne
    private Role role;

    /**
     * Get the value of role
     *
     * @return the value of role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Set the value of role
     *
     * @param role new value of role
     */
    public void setRole(Role role) {
        this.role = role;
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

    
}
