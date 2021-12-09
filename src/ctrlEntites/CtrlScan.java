package ctrlEntites;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import application.DatabaseConnection;
import entites.Scan;

public class CtrlScan {
	
	private Collection<Scan> listeScans = new ArrayList<Scan>();

	public Collection<Scan> getListeScans() {
		return listeScans;
	}

	public void setListeScans(Collection<Scan> listeScans) {
		this.listeScans = listeScans;
	}
	
	public void ajouteListeScans(Scan scan) {
		this.listeScans.add(scan);
	}
	
	public boolean envoyerScanDB() throws SQLException {
		DatabaseConnection connectionDB = new DatabaseConnection();
		Connection connection = connectionDB.getConnection();
		String requeteInsert = "insert into scan(Nom_Scan) values "; 
		
		for(Scan scan:  this.listeScans) {
			requeteInsert += "(\""+ scan.getNomScan() + "\"),";
		}
		requeteInsert = requeteInsert.substring(0, requeteInsert.length()-1);
		
		Statement requeteFinal = connection.createStatement();
		
		if(requeteFinal.execute(requeteInsert)) {
			connection.close();
			return true;
		}
		else {
			connection.close();
			return false;
		}
	}
	
	public void importerScanDB() throws SQLException {
		DatabaseConnection connectionDB = new DatabaseConnection();
		Connection connection = connectionDB.getConnection();
		String requeteInsert = "select * from scan;";
		Statement requeteFinal = connection.createStatement();
		ResultSet resultats = requeteFinal.executeQuery(requeteInsert);
		
		while(resultats.next()) {
			this.listeScans.add(new Scan(resultats.getInt("Id_Scan"),resultats.getString("Nom_Scan")));
		}
		connection.close();
	}
	

}
