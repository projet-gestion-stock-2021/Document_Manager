package application;

import java.net.URL;
import java.nio.file.attribute.FileTime;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import ctrlEntites.CtrlDocument;
import ctrlEntites.CtrlDossier;
import ctrlEntites.CtrlTypeDoc;
import ctrlEntites.CtrlTypeDossier;
import entity.Document;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;


public class InterfaceRechercheController implements Initializable
{

	@FXML
	private Button annulerButton, switchSceneButton;
	@FXML
	private TableView<Document> documentTable;
	@FXML
	private TextField searchField;
	@FXML
	private TextField labelSearch1, labelSearch2;
	
    //public ObservableList<Document> observableDocs = FXCollections.observableArrayList();
//    List<Document> listDoc = new LinkedList<Document>();
    
	private CtrlDocument ctrlDoc = new CtrlDocument();
	
	public void switchDashboard () 
	{
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			Stage individuStage = new Stage();
			individuStage.setScene(new Scene(root));
			individuStage.show();
			Stage stage = (Stage) annulerButton.getScene().getWindow();
			stage.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			e.getCause();
		}
	}
	
	public void switchSceneOnAction () 
	{
		try 
		{
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("InterfaceCreation.fxml"));
			Stage individuStage = new Stage();
			individuStage.setScene(new Scene(root));
			individuStage.show();
			Stage stage = (Stage) switchSceneButton.getScene().getWindow();
			stage.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			e.getCause();
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		
		//ok ça crée bien une colonne avec le bon nom
		TableColumn<Document, String> col_DocumentName = new TableColumn<Document, String>("Nom document");
		TableColumn<Document, LocalDate> col_DocumentDate = new TableColumn<Document, LocalDate>("Date de scan");
		TableColumn<Document, FileTime> col_DocumentLastModified = new TableColumn<Document, FileTime>("Dernière modification");
		//TableColumn<Document, String> col_DocumentPath = new TableColumn<Document, String>("Chemin");
		
		documentTable.getColumns().setAll(col_DocumentName, col_DocumentDate, col_DocumentLastModified);
		
		//ENFIN!!!!!! le nom du doc s'affiche dans la colonne, Merci Oracle!
		col_DocumentName.setCellValueFactory(new Callback<CellDataFeatures<Document, String>, ObservableValue<String>>() 
		{
		     public ObservableValue<String> call(CellDataFeatures<Document, String> p) 
		     {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return p.getValue().documentNameProperty();
		     }
		  });
		
		col_DocumentDate.setCellValueFactory(new Callback<CellDataFeatures<Document, LocalDate>, ObservableValue<LocalDate>>() 
		{
		     public ObservableValue<LocalDate> call(CellDataFeatures<Document, LocalDate> p) 
		     {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return p.getValue().documentDateScanProperty();
		     }
		  });
		
		col_DocumentLastModified.setCellValueFactory(new Callback<CellDataFeatures<Document, FileTime>, ObservableValue<FileTime>>() 
		{
		     public ObservableValue<FileTime> call(CellDataFeatures<Document, FileTime> p) 
		     {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return p.getValue().documentDateModifiedProperty();
		     }
		  });
		 
		
		try 
		{
			ctrlDoc.charger();
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ctrlDoc.getListeDoc().forEach(i -> System.out.println("DOC: "+i.getNomDocument()));
		documentTable.setItems(ctrlDoc.getListeDoc());
		
	}
}
