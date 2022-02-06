package ctrlEntites;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.DatabaseConnection;
import entity.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CtrlUser {
		
	private ObservableList<Utilisateur> listeAfficheUti = FXCollections.observableArrayList();
	private Connection connexion = DatabaseConnection.getInstance().getConnection();

	public ObservableList<Utilisateur> getListeAfficheUti() {
		return listeAfficheUti;
	}

	public void setListeTag(ObservableList<Utilisateur> listeAfficheUti) {
		this.listeAfficheUti = listeAfficheUti;
	}

	public void charger() throws SQLException {
		System.out.println("\nCharger liste utilisateur\n");
		
		CallableStatement fctCall = connexion.prepareCall("{call select_utilisateur()}"); 
		ResultSet resultatRequete = fctCall.executeQuery();
		
		while(resultatRequete.next())
		{
			 //if(!resultatRequete.getBoolean("Flag_type_de_document"))
			// {
				 listeAfficheUti.add(new Utilisateur(resultatRequete));
			// }		     
		}
	}
	
}
