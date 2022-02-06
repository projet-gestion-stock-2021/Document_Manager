package ctrlEntites;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import application.SingleConnection;
import application2.AbstractDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import entity.TypeDossier;

public class CtrlTypeDossier extends AbstractDAO{
	
	private ObservableList<TypeDossier> listeDossier = FXCollections.observableArrayList();
	
	public ObservableList<TypeDossier> getListeDossier() {
		return listeDossier;
	}



	public void setListeDossier(ObservableList<TypeDossier> listeDossier) {
		this.listeDossier = listeDossier;
	}
	
	public void charger() throws SQLException {
		CallableStatement fctCall = connection.prepareCall("{call select_type_dossier()}"); 
		ResultSet resultatRequete = fctCall.executeQuery();
		
		while(resultatRequete.next())
		{
			 if(!resultatRequete.getBoolean("Flag_type_dossier"))
			 {
				 listeDossier.add(new TypeDossier(resultatRequete));
			 }		     
		}
	}

	

}
