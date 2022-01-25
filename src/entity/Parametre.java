package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parametre {
    private int idParametre;
    private String pathStock;
    private String pathBackup;
    private String directoryPath;

    @Id
    @Column(name = "Id_Parametre")
    public int getIdParametre() {
        return idParametre;
    }

    public void setIdParametre(int idParametre) {
        this.idParametre = idParametre;
    }

    @Basic
    @Column(name = "Path_Stock")
    public String getPathStock() {
        return pathStock;
    }

    public void setPathStock(String pathStock) {
        this.pathStock = pathStock;
    }

    @Basic
    @Column(name = "Path_Backup")
    public String getPathBackup() {
        return pathBackup;
    }

    public void setPathBackup(String pathBackup) {
        this.pathBackup = pathBackup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parametre parametre = (Parametre) o;

        if (idParametre != parametre.idParametre) return false;
        if (pathStock != null ? !pathStock.equals(parametre.pathStock) : parametre.pathStock != null) return false;
        if (pathBackup != null ? !pathBackup.equals(parametre.pathBackup) : parametre.pathBackup != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idParametre;
        result = 31 * result + (pathStock != null ? pathStock.hashCode() : 0);
        result = 31 * result + (pathBackup != null ? pathBackup.hashCode() : 0);
        return result;
    }

	public String getDirectoryPath() {
		return directoryPath;
	}

	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}
}
