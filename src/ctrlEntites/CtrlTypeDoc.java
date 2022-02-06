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

import application.SingleConnection;
import application2.AbstractDAO;
import entity.Document;
import entity.TypeDeDocument;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

public class CtrlTypeDoc extends AbstractDAO{
	
	private ObservableList<TypeDeDocument> listeTypeDoc = FXCollections.observableArrayList();
	
	public ObservableList<TypeDeDocument> getListeTypeDoc() {
		return listeTypeDoc;
	}

	public void setListeTag(ObservableList<TypeDeDocument> listeTypeDoc) {
		this.listeTypeDoc = listeTypeDoc;
	}

	public void charger() throws SQLException {
		System.out.println("\nCharger type doc\n");
		
		CallableStatement fctCall = connection.prepareCall("{call select_type_de_document()}"); 
		ResultSet resultatRequete = fctCall.executeQuery();
		
		while(resultatRequete.next())
		{
			 if(!resultatRequete.getBoolean("Flag_type_de_document"))
			 {
				 listeTypeDoc.add(new TypeDeDocument(resultatRequete));
			 }		     
		}
	}



	

}
