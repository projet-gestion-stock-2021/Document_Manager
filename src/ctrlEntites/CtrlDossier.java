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

import entity.Dossier;

public class CtrlDossier{
	
	private ObservableList<Dossier> listeDossier = FXCollections.observableArrayList();
	private Connection connexion = DatabaseConnection.getInstance().getConnection();
	
	
	
	public ObservableList<Dossier> getListeDossier() 
	{
		return listeDossier;
	}



	public void setListeDossier(ObservableList<Dossier> listeDossier) 
	{
		this.listeDossier = listeDossier;
	}

	public void charger() throws SQLException 
	{
		CallableStatement fctCall = connexion.prepareCall("{call select_dossier()}"); 
		ResultSet resultatRequete = fctCall.executeQuery();
		
		while(resultatRequete.next())
		{
			 if(!resultatRequete.getBoolean("Flag_dossier"))
			 {
				 
				 listeDossier.add(new Dossier(resultatRequete));
			 }		     
		}
	}




	

}
