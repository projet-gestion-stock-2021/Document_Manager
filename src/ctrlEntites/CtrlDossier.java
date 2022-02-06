package ctrlEntites;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import application.SingleConnection;
import application2.AbstractDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import entity.Dossier;

public class CtrlDossier extends AbstractDAO{
	
	private ObservableList<Dossier> listeTypeDossier = FXCollections.observableArrayList();
	
	
	
	
	public ObservableList<Dossier> getListeTypeDossier() 
	{
		return listeTypeDossier;
	}



	public void setListeTypeDossier(ObservableList<Dossier> listeTypeDossier) 
	{
		this.listeTypeDossier = listeTypeDossier;
	}

	public void charger() throws SQLException 
	{
		CallableStatement fctCall = connection.prepareCall("{call select_dossier()}"); 
		ResultSet resultatRequete = fctCall.executeQuery();
		
		while(resultatRequete.next())
		{
			 if(!resultatRequete.getBoolean("Flag_dossier"))
			 {
				 
				 listeTypeDossier.add(new Dossier(resultatRequete));
			 }		     
		}
	}




	

}
