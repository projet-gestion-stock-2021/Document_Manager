package application;

import java.net.URL;
import java.util.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import ctrlEntites.CtrlDocument;
import ctrlEntites.CtrlDossier;
import ctrlEntites.CtrlTypeDoc;
import ctrlEntites.CtrlTypeDossier;
import entites.Document;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class InterfaceCreationController implements Initializable{
	
	private CtrlDocument ctrlDoc = new CtrlDocument();
	private CtrlDossier ctrlDossier = new CtrlDossier();
	private CtrlTypeDossier ctrlTypeDossier = new CtrlTypeDossier();
	private CtrlTypeDoc  ctrlTypeDoc = new CtrlTypeDoc();
	
	// Parametres fxml
	@FXML
	private Button annulerButton;
	@FXML
	private TextField nomDoc;
	@FXML
	private TextField tagPerso1;
	@FXML
	private TextField tagPerso2;
	@FXML
	private ChoiceBox tag1;
	@FXML
	private ChoiceBox tag2;
	@FXML
	private ChoiceBox tag3;
    @FXML
	private DatePicker dateC;
    
	
	public void valider() {
		int idDocument = ctrlDoc.getIdCourant() + 1;
		ctrlDoc.setIdCourant(idDocument);
	    String nomDocument = nomDoc.getText();
	    LocalDate dateDocument = dateC.getValue();
	    Instant inst = Instant.from(dateDocument.atStartOfDay(ZoneId.systemDefault()));
	    Date dateDoc = Date.from(inst);
	    Boolean flagDocument = false;
		
		ctrlDoc.getListeDoc().add(new Document(idDocument,nomDocument,dateDoc,null,flagDocument));
		for(Document doc: ctrlDoc.getListeDoc())
		{
			System.out.println("Nom : " + doc.getNomDocument() +  "\n Date : " + doc.getDateDocument() + "\n ----------------" );
			
		}
	}
	
	public void rechercher() {
		
	}
	
	public void switchDashboard () {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			Stage individuStage = new Stage();
			
			individuStage.setScene(new Scene(root,778,605));
			individuStage.show();
			Stage stage = (Stage) annulerButton.getScene().getWindow();
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		try {
			ctrlDoc.charger();
			ctrlDossier.charger();
			ctrlTypeDoc.charger();
			ctrlTypeDossier.charger();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.tag1.setItems(ctrlTypeDoc.getListeTypeDoc());
		this.tag2.setItems(ctrlDossier.getListeTypeDossier());
		this.tag3.setItems(ctrlTypeDossier.getListeDossier());
		
	}



}
