package entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "document_temp", schema = "testdm", catalog = "")
public class DocumentTemp {
    private int idDocumentTemp;
    private String nomDocumentTemp;
    private Timestamp dateDocumentTemp;

    @Id
    @Column(name = "Id_Document_Temp")
    public int getIdDocumentTemp() {
        return idDocumentTemp;
    }

    public void setIdDocumentTemp(int idDocumentTemp) {
        this.idDocumentTemp = idDocumentTemp;
    }

    @Basic
    @Column(name = "Nom_Document_Temp")
    public String getNomDocumentTemp() {
        return nomDocumentTemp;
    }

    public void setNomDocumentTemp(String nomDocumentTemp) {
        this.nomDocumentTemp = nomDocumentTemp;
    }

    @Basic
    @Column(name = "Date_Document_Temp")
    public Timestamp getDateDocumentTemp() {
        return dateDocumentTemp;
    }

    public void setDateDocumentTemp(Timestamp dateDocumentTemp) {
        this.dateDocumentTemp = dateDocumentTemp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentTemp that = (DocumentTemp) o;

        if (idDocumentTemp != that.idDocumentTemp) return false;
        if (nomDocumentTemp != null ? !nomDocumentTemp.equals(that.nomDocumentTemp) : that.nomDocumentTemp != null)
            return false;
        if (dateDocumentTemp != null ? !dateDocumentTemp.equals(that.dateDocumentTemp) : that.dateDocumentTemp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDocumentTemp;
        result = 31 * result + (nomDocumentTemp != null ? nomDocumentTemp.hashCode() : 0);
        result = 31 * result + (dateDocumentTemp != null ? dateDocumentTemp.hashCode() : 0);
        return result;
    }
}
