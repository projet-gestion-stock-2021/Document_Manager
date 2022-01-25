package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TyperPK implements Serializable {
    private int idDocument;
    private int idReference;

    @Column(name = "Id_Document")
    @Id
    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    @Column(name = "Id_Reference")
    @Id
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

        TyperPK typerPK = (TyperPK) o;

        if (idDocument != typerPK.idDocument) return false;
        if (idReference != typerPK.idReference) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDocument;
        result = 31 * result + idReference;
        return result;
    }
}
