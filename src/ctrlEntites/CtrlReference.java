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

import entity.Reference;

public class CtrlReference{
	
	private ObservableList<Reference> listeReference = FXCollections.observableArrayList();
	private Connection connexion = DatabaseConnection.getInstance().getConnection();
	

	public ObservableList<Reference> getListeDossier() {
		return listeReference;
	}



	public void setListeDossier(ObservableList<Reference> listeReference) {
		this.listeReference = listeReference;
	}
	
	public void charger() throws SQLException {
		CallableStatement fctCall = connexion.prepareCall("{call select_reference()}"); 
		ResultSet resultatRequete = fctCall.executeQuery();
		
		while(resultatRequete.next())
		{

				 listeReference.add(new Reference(resultatRequete));
			
		}
	}

	

}
