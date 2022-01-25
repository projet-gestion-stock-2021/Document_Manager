package entity;

import javax.persistence.*;

@Entity
@Table(name = "niv_scan", schema = "testdm", catalog = "")
@IdClass(NivScanPK.class)
public class NivScan {
    private int idNiveau;
    private int idScan;
    private Niveau niveauByIdNiveau;
    private Scan scanByIdScan;

    @Id
    @Column(name = "Id_Niveau")
    public int getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(int idNiveau) {
        this.idNiveau = idNiveau;
    }

    @Id
    @Column(name = "Id_Scan")
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

        NivScan nivScan = (NivScan) o;

        if (idNiveau != nivScan.idNiveau) return false;
        if (idScan != nivScan.idScan) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNiveau;
        result = 31 * result + idScan;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Id_Niveau", referencedColumnName = "Id_Niveau", nullable = false)
    public Niveau getNiveauByIdNiveau() {
        return niveauByIdNiveau;
    }

    public void setNiveauByIdNiveau(Niveau niveauByIdNiveau) {
        this.niveauByIdNiveau = niveauByIdNiveau;
    }

    @ManyToOne
    @JoinColumn(name = "Id_Scan", referencedColumnName = "Id_Scan", nullable = false)
    public Scan getScanByIdScan() {
        return scanByIdScan;
    }

    public void setScanByIdScan(Scan scanByIdScan) {
        this.scanByIdScan = scanByIdScan;
    }
}
