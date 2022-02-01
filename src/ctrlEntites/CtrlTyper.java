package ctrlEntites;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.DatabaseConnection;
import entity.Typer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CtrlTyper {

	private ObservableList<Typer> listeRecherche = FXCollections.observableArrayList();
	private Connection connexion = DatabaseConnection.getInstance().getConnection();
	
	public ObservableList<Typer> getListeRecherche() {
		return listeRecherche;
	}



	public void setListeDossier(ObservableList<Typer> listeRecherche) {
		this.listeRecherche = listeRecherche;
	}
	
	public void afficherRecherche() throws SQLException {
		CallableStatement fctCall = connexion.prepareCall("{call select_recherche_doc()}"); 
		ResultSet resultatRequete = fctCall.executeQuery();
		
		while(resultatRequete.next())
		{
			 if(resultatRequete!=null)
			 {
				 listeRecherche.add(new Typer(resultatRequete));
			 }		     
		}
	}
}
