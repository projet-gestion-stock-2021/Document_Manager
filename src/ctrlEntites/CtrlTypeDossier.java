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

import entity.TypeDossier;

public class CtrlTypeDossier{
	
	private ObservableList<TypeDossier> listeTypeDossier = FXCollections.observableArrayList();
	private Connection connexion = DatabaseConnection.getInstance().getConnection();
	

	public ObservableList<TypeDossier> getListeTypeDossier() {
		return listeTypeDossier;
	}



	public void setListeTypeDossier(ObservableList<TypeDossier> listeTypeDossier) {
		this.listeTypeDossier = listeTypeDossier;
	}
	
	public void charger() throws SQLException {
		CallableStatement fctCall = connexion.prepareCall("{call select_type_dossier()}"); 
		ResultSet resultatRequete = fctCall.executeQuery();
		
		while(resultatRequete.next())
		{
			 if(!resultatRequete.getBoolean("Flag_type_dossier"))
			 {
				 listeTypeDossier.add(new TypeDossier(resultatRequete));
			 }		     
		}
	}

	

}
