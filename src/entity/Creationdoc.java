package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Creationdoc {
    private int idCreationDoc;
    private Timestamp dateCreation;
    private Utilisateur utilisateurByIdUtilisateur;
    private Collection<Document> documentsByIdCreationDoc;

    @Id
    @Column(name = "Id_CreationDoc")
    public int getIdCreationDoc() {
        return idCreationDoc;
    }

    public void setIdCreationDoc(int idCreationDoc) {
        this.idCreationDoc = idCreationDoc;
    }

    @Basic
    @Column(name = "DateCreation")
    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Creationdoc that = (Creationdoc) o;

        if (idCreationDoc != that.idCreationDoc) return false;
        if (dateCreation != null ? !dateCreation.equals(that.dateCreation) : that.dateCreation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCreationDoc;
        result = 31 * result + (dateCreation != null ? dateCreation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Id_Utilisateur", referencedColumnName = "Id_Utilisateur", nullable = false)
    public Utilisateur getUtilisateurByIdUtilisateur() {
        return utilisateurByIdUtilisateur;
    }

    public void setUtilisateurByIdUtilisateur(Utilisateur utilisateurByIdUtilisateur) {
        this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
    }

    @OneToMany(mappedBy = "creationdocByIdCreationDoc")
    public Collection<Document> getDocumentsByIdCreationDoc() {
        return documentsByIdCreationDoc;
    }

    public void setDocumentsByIdCreationDoc(Collection<Document> documentsByIdCreationDoc) {
        this.documentsByIdCreationDoc = documentsByIdCreationDoc;
    }
}
