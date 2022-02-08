package ctrlEntites;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

import entity.Document;
import entity.Dossier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import application.DatabaseConnection;

public class CtrlDocument{
	
	//private Collection<Document> listeDoc = new ArrayList<Document>();
	private ObservableList<Document> observableDoc = FXCollections.observableArrayList();
	private Connection connexion = DatabaseConnection.getInstance().getConnection();
	private int idCourant;
	
	public int getIdCourant() 
	{
		return idCourant;
	}

	public void setIdCourant(int idCourant) 
	{
		this.idCourant = idCourant;
	}

	public void charger() throws SQLException
	{
		
		CallableStatement fctCall = connexion.prepareCall("{call select_document()}"); 
		ResultSet resultatRequete = fctCall.executeQuery();
		
		while(resultatRequete.next())
		{	     
		     //listeDoc.add(new Document(resultatRequete));
			observableDoc.add(new Document(resultatRequete));
		     
//		     if(!resultatRequete.next()) {
//		    	 this.setIdCourant(resultatRequete.getInt("Id_Document"));
//		     }
		}
		
	}

//	public Collection<Document> getListeDoc() {
//		return listeDoc;
//	}
//
//	public void setListeDoc(Collection<Document> listeDoc) {
//		this.listeDoc = listeDoc;
//	}

	public ObservableList<Document> getListeDoc() 
	{
		//observableDoc.forEach(i -> System.out.println(i.getNomDocument()));
		return observableDoc;
	}



	public void setListeDoc(ObservableList<Document> listeDoc) 
	{
		this.observableDoc = listeDoc;
	}

	
	

}
