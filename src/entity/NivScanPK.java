package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class NivScanPK implements Serializable {
    private int idNiveau;
    private int idScan;

    @Column(name = "Id_Niveau")
    @Id
    public int getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(int idNiveau) {
        this.idNiveau = idNiveau;
    }

    @Column(name = "Id_Scan")
    @Id
    public int getIdScan() {
        return idScan;
    }

    public void setIdScan(int idScan) {
        this.idScan = idScan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NivScanPK nivScanPK = (NivScanPK) o;

        if (idNiveau != nivScanPK.idNiveau) return false;
        if (idScan != nivScanPK.idScan) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNiveau;
        result = 31 * result + idScan;
        return result;
    }
}
