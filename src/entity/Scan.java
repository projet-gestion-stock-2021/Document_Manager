package entity;

import javax.persistence.*;

import javafx.beans.property.SimpleStringProperty;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Entity
public class Scan {
    private int idScan;
    private Path pathScan;
    private Collection<NivScan> nivScansByIdScan;

    public Scan(ResultSet resultatRequete) 
    {
    	try 
    	{
    		this.setIdScan(resultatRequete.getInt("Id_Scan"));
    		this.setpathScan(resultatRequete.getString("Nom_Scan"));
    	} 
    	catch (SQLException e) 
    	{
    		System.out.println("\nProbleme Scan(ResultSet rst)\n");
    		e.printStackTrace();
    	}
	}

	public Scan() {
		// TODO Auto-generated constructor stub
	}

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
    public Path getpathScan() 
    {
        return pathScan;
    }

    public void setpathScan(Path nomScan) 
    {
        this.pathScan = nomScan;
    }
    
    public void setpathScan(String nomScan) 
    {
        this.pathScan = Paths.get(nomScan);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Scan scan = (Scan) o;

        if (idScan != scan.idScan) return false;
        if (pathScan != null ? !pathScan.equals(scan.pathScan) : scan.pathScan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idScan;
        result = 31 * result + (pathScan != null ? pathScan.hashCode() : 0);
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
