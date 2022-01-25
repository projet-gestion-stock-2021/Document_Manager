package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Scan {
    private int idScan;
    private String nomScan;
    private Collection<NivScan> nivScansByIdScan;

    @Id
    @Column(name = "Id_Scan")
    public int getIdScan() {
        return idScan;
    }

    public void setIdScan(int idScan) {
        this.idScan = idScan;
    }

    @Basic
    @Column(name = "Nom_Scan")
    public String getNomScan() {
        return nomScan;
    }

    public void setNomScan(String nomScan) {
        this.nomScan = nomScan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Scan scan = (Scan) o;

        if (idScan != scan.idScan) return false;
        if (nomScan != null ? !nomScan.equals(scan.nomScan) : scan.nomScan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idScan;
        result = 31 * result + (nomScan != null ? nomScan.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "scanByIdScan")
    public Collection<NivScan> getNivScansByIdScan() {
        return nivScansByIdScan;
    }

    public void setNivScansByIdScan(Collection<NivScan> nivScansByIdScan) {
        this.nivScansByIdScan = nivScansByIdScan;
    }
}
