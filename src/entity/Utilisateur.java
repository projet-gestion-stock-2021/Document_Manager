package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Utilisateur {
    private int idUtilisateur;
    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    private Byte flagUtilisateur;
    private Collection<Creationdoc> creationdocsByIdUtilisateur;
    private Niveau niveauByIdNiveau;

    @Id
    @Column(name = "Id_Utilisateur")
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Basic
    @Column(name = "Nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "Prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "Login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "Mdp")
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Basic
    @Column(name = "Flag_Utilisateur")
    public Byte getFlagUtilisateur() {
        return flagUtilisateur;
    }

    public void setFlagUtilisateur(Byte flagUtilisateur) {
        this.flagUtilisateur = flagUtilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilisateur that = (Utilisateur) o;

        if (idUtilisateur != that.idUtilisateur) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (mdp != null ? !mdp.equals(that.mdp) : that.mdp != null) return false;
        if (flagUtilisateur != null ? !flagUtilisateur.equals(that.flagUtilisateur) : that.flagUtilisateur != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUtilisateur;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (mdp != null ? mdp.hashCode() : 0);
        result = 31 * result + (flagUtilisateur != null ? flagUtilisateur.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "utilisateurByIdUtilisateur")
    public Collection<Creationdoc> getCreationdocsByIdUtilisateur() {
        return creationdocsByIdUtilisateur;
    }

    public void setCreationdocsByIdUtilisateur(Collection<Creationdoc> creationdocsByIdUtilisateur) {
        this.creationdocsByIdUtilisateur = creationdocsByIdUtilisateur;
    }

    @ManyToOne
    @JoinColumn(name = "Id_Niveau", referencedColumnName = "Id_Niveau", nullable = false)
    public Niveau getNiveauByIdNiveau() {
        return niveauByIdNiveau;
    }

    public void setNiveauByIdNiveau(Niveau niveauByIdNiveau) {
        this.niveauByIdNiveau = niveauByIdNiveau;
    }
}
