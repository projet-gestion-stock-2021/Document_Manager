package entity;

import javax.persistence.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;


@Entity
@Table(name = "type_de_document", schema = "testdm", catalog = "")
public class TypeDeDocument {
    private int idTypeDeDocument;
    private String nomTypeDoc;
    private Boolean flagTypeDoc;
    private Collection<Document> documentsByIdTypeDeDocument;
    private Dossier dossierByIdDossier;

    public TypeDeDocument(ResultSet rst)
    {
    	try 
    	{
			this.setIdTypeDeDocument(rst.getInt("Id_Type_De_Document"));
			this.setNomTypeDoc(rst.getString("Nom_type_de_document"));
			this.setFlagTypeDoc(rst.getBoolean("Flag_type_de_document"));
			//this.setTypeDossierByIdTypeDossier(typeDossierByIdTypeDossier.set);
			
		} 
    	catch (SQLException e) 
    	{
			System.out.println("\nProbleme TypeDeDocument(ResultSet rst)\n");
			e.printStackTrace();
		}
    }

    /*
     * to display the TypeDeDocument object name in the comboBox
     */
    @Override
    public String toString() 
    {
		return this.getIdTypeDeDocument() +" "+ this.getNomTypeDoc();
    	 
    }
    
    @Id
    @Column(name = "Id_Type_De_Document")
    public int getIdTypeDeDocument() {
        return idTypeDeDocument;
    }

    public void setIdTypeDeDocument(int idTypeDeDocument) {
        this.idTypeDeDocument = idTypeDeDocument;
    }

    @Basic
    @Column(name = "Nom_TypeDoc")
    public String getNomTypeDoc() {
        return nomTypeDoc;
    }

    public void setNomTypeDoc(String nomTypeDoc) {
        this.nomTypeDoc = nomTypeDoc;
    }

    @Basic
    @Column(name = "Flag_TypeDoc")
    public Boolean getFlagTypeDoc() {
        return flagTypeDoc;
    }

    public void setFlagTypeDoc(Boolean flagTypeDoc) {
        this.flagTypeDoc = flagTypeDoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeDeDocument that = (TypeDeDocument) o;

        if (idTypeDeDocument != that.idTypeDeDocument) return false;
        if (nomTypeDoc != null ? !nomTypeDoc.equals(that.nomTypeDoc) : that.nomTypeDoc != null) return false;
        if (flagTypeDoc != null ? !flagTypeDoc.equals(that.flagTypeDoc) : that.flagTypeDoc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTypeDeDocument;
        result = 31 * result + (nomTypeDoc != null ? nomTypeDoc.hashCode() : 0);
        result = 31 * result + (flagTypeDoc != null ? flagTypeDoc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typeDeDocumentByIdTypeDeDocument")
    public Collection<Document> getDocumentsByIdTypeDeDocument() {
        return documentsByIdTypeDeDocument;
    }

    public void setDocumentsByIdTypeDeDocument(Collection<Document> documentsByIdTypeDeDocument) {
        this.documentsByIdTypeDeDocument = documentsByIdTypeDeDocument;
    }

    @ManyToOne
    @JoinColumn(name = "Id_Dossier", referencedColumnName = "Id_Dossier", nullable = false)
    public Dossier getDossierByIdDossier() {
        return dossierByIdDossier;
    }

    public void setDossierByIdDossier(Dossier dossierByIdDossier) {
        this.dossierByIdDossier = dossierByIdDossier;
    }
}
