package ctrlEntites;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import application.DatabaseConnection;
import entites.Document;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

public class CtrlTypeDoc{
	
	private ObservableList<String> listeTypeDoc = FXCollections.observableArrayList();
	private Connection connexion = DatabaseConnection.getInstance().getConnection();

	public ObservableList<String> getListeTypeDoc() {
		return listeTypeDoc;
	}

	public void setListeTag(ObservableList<String> listeTypeDoc) {
		this.listeTypeDoc = listeTypeDoc;
	}

	public void charger() throws SQLException {
		CallableStatement fctCall = connexion.prepareCall("{call select_type_de_document()}"); 
		ResultSet resultatRequete = fctCall.executeQuery();
		
		while(resultatRequete.next())
		{
			 if(!resultatRequete.getBoolean("Flag_type_de_document"))
			 {
				 listeTypeDoc.add(resultatRequete.getString("Nom_type_de_document"));
			 }		     
		}
	}



	

}
