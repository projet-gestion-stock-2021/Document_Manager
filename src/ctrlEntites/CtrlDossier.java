package ctrlEntites;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import application.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

public class CtrlDossier{
	
	private ObservableList<String> listeTypeDossier = FXCollections.observableArrayList();
	private Connection connexion = DatabaseConnection.getInstance().getConnection();
	
	
	
	public ObservableList<String> getListeTypeDossier() {
		return listeTypeDossier;
	}



	public void setListeTypeDossier(ObservableList<String> listeTypeDossier) {
		this.listeTypeDossier = listeTypeDossier;
	}

	public void charger() throws SQLException {
		CallableStatement fctCall = connexion.prepareCall("{call select_type_dossier()}"); 
		ResultSet resultatRequete = fctCall.executeQuery();
		
		while(resultatRequete.next())
		{
			 if(!resultatRequete.getBoolean("Flag_type_dossier"))
			 {
				 listeTypeDossier.add(resultatRequete.getString("Nom_type_dossier"));
			 }		     
		}
	}




	

}
