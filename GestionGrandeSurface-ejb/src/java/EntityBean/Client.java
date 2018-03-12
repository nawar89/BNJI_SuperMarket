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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Nawar
 */
@Entity
public class Client implements Serializable {

    @OneToMany(mappedBy = "client")
    private List<CommandeClientCaisse> commandeClientCaisses;

    public List<CommandeClientCaisse> getCommandeClientCaisses() {
        return commandeClientCaisses;
    }

    public void setCommandeClientCaisses(List<CommandeClientCaisse> commandeClientCaisses) {
        this.commandeClientCaisses = commandeClientCaisses;
    }

    public List<CommandeClientEnLigne> getCommandeClientEnLignes() {
        return commandeClientEnLignes;
    }

    public void setCommandeClientEnLignes(List<CommandeClientEnLigne> commandeClientEnLignes) {
        this.commandeClientEnLignes = commandeClientEnLignes;
    }

    @OneToMany(mappedBy = "client")
    private List<CommandeClientEnLigne> commandeClientEnLignes;

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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBean.Client[ id=" + id + " ]";
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

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;

    /**
     * Get the value of dateNaissance
     *
     * @return the value of dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Set the value of dateNaissance
     *
     * @param dateNaissance new value of dateNaissance
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

        private String code_client;

    /**
     * Get the value of code_client
     *
     * @return the value of code_client
     */
    public String getCode_client() {
        return code_client;
    }

    /**
     * Set the value of code_client
     *
     * @param code_client new value of code_client
     */
    public void setCode_client(String code_client) {
        this.code_client = code_client;
    }

    
}
