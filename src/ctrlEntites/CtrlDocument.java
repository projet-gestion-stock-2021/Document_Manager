package ctrlEntites;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

import entites.Document;
import javafx.fxml.Initializable;
import application.DatabaseConnection;

public class CtrlDocument{
	
	private Collection<Document> listeDoc = new ArrayList<Document>();
	private Connection connexion = DatabaseConnection.getInstance().getConnection();
	private int idCourant;
	
	public int getIdCourant() {
		return idCourant;
	}

	public void setIdCourant(int idCourant) {
		this.idCourant = idCourant;
	}

	public void charger() throws SQLException {
		
		CallableStatement fctCall = connexion.prepareCall("{call select_document()}"); 
		ResultSet resultatRequete = fctCall.executeQuery();
		
		while(resultatRequete.next())
		{
			 int idDocument = resultatRequete.getInt("Id_Document");
		     String nomDocument = resultatRequete.getString("Nom_Document");
		     Date dateDocument = resultatRequete.getDate("DateDocument");
		     Timestamp dateScan = resultatRequete.getTimestamp("DateScan");
		     Boolean flagDocument = resultatRequete.getBoolean("Flag_document");
		     
		     listeDoc.add(new Document(idDocument,nomDocument,dateDocument,dateScan,flagDocument));
		     
		     if(!resultatRequete.next()) {
		    	 this.setIdCourant(idDocument);
		     }
		}
		
	}

	public Collection<Document> getListeDoc() {
		return listeDoc;
	}

	public void setListeDoc(Collection<Document> listeDoc) {
		this.listeDoc = listeDoc;
	}


	
	

}
