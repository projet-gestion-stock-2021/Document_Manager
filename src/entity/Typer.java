package entity;

import java.sql.ResultSet;

import javax.persistence.*;

@Entity
@IdClass(TyperPK.class)
public class Typer {
    private int idDocument;
    private int idReference;
    private Document documentByIdDocument;
    private Reference referenceByIdReference;

   

	public Typer(ResultSet resultatRequete) {
		// TODO Auto-generated constructor stub
	}

	@Id
    @Column(name = "Id_Document")
    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    @Id
    @Column(name = "Id_Reference")
    public int getIdReference() {
        return idReference;
    }

    public void setIdReference(int idReference) {
        this.idReference = idReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Typer typer = (Typer) o;

        if (idDocument != typer.idDocument) return false;
        if (idReference != typer.idReference) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDocument;
        result = 31 * result + idReference;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Id_Document", referencedColumnName = "Id_Document", nullable = false)
    public Document getDocumentByIdDocument() {
        return documentByIdDocument;
    }

    public void setDocumentByIdDocument(Document documentByIdDocument) {
        this.documentByIdDocument = documentByIdDocument;
    }

    @ManyToOne
    @JoinColumn(name = "Id_Reference", referencedColumnName = "Id_Reference", nullable = false)
    public Reference getReferenceByIdReference() {
        return referenceByIdReference;
    }

    public void setReferenceByIdReference(Reference referenceByIdReference) 
    {
        this.referenceByIdReference = referenceByIdReference;
    }
}
