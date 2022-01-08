package ctrlEntites;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import application.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

public class CtrlTypeDossier{
	
	private ObservableList<String> listeDossier = FXCollections.observableArrayList();
	private Connection connexion = DatabaseConnection.getInstance().getConnection();
	

	public ObservableList<String> getListeDossier() {
		return listeDossier;
	}



	public void setListeDossier(ObservableList<String> listeDossier) {
		this.listeDossier = listeDossier;
	}
	
	public void charger() throws SQLException {
		CallableStatement fctCall = connexion.prepareCall("{call select_dossier()}"); 
		ResultSet resultatRequete = fctCall.executeQuery();
		
		while(resultatRequete.next())
		{
			 if(!resultatRequete.getBoolean("Flag_dossier"))
			 {
				 listeDossier.add(resultatRequete.getString("Nom_dossier"));
			 }		     
		}
	}

	

}
