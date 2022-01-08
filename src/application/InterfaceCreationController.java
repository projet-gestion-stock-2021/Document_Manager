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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import java.awt.Desktop;
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
	private AnchorPane anchorpane;
	@FXML
	private Button annulerButton;
	@FXML
	private Button bnt_browser;
	@FXML
	private TextArea textarea;
	@FXML
	private Label labelTest;
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
	
	public void switchDashboard() {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			Stage individuStage = new Stage();

			individuStage.setScene(new Scene(root, 778, 605));
			individuStage.show();
			Stage stage = (Stage) annulerButton.getScene().getWindow();
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}


	FileChooser file = new FileChooser();



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
				file.setInitialDirectory(
				new File("C:\\Users\\Meriem\\Dropbox\\Mon PC (DESKTOP-29Q3FOJ)\\Desktop\\Nouveau dossier"));
		
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



	@FXML
	public void browser() {
		try {
			file.setTitle("Ouvrir un document");
			file.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"),new ExtensionFilter("PDF", "*.pdf"));
			File selectedFile = file.showOpenDialog(null);
			if (selectedFile != null) {
				 Desktop desktop = Desktop.getDesktop();
				desktop.open(selectedFile);
				/*Scanner scanner = new Scanner(selectedFile);
				while (scanner.hasNextLine()) {
					textarea.appendText(scanner.nextLine());*/
				//}

			}

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}

	public void save(MouseEvent event) {

		File file1 = file.showSaveDialog(new Stage());
		if (file1 != null) {
			saveSystem(file1, textarea.getText());

		}
	}


	public void saveSystem(File file, String content) {
		try {
			PrintWriter printWriter = new PrintWriter(file);
			printWriter.write(content);
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
