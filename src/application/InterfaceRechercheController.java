package application;

import java.net.URL;
import java.nio.file.attribute.FileTime;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

<<<<<<< Updated upstream
import application2.Utilisateur;
=======
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;

import AutoCompletionComponent.AutocompleteMultiSelectionBox;
import application2.AbstractDAO;
>>>>>>> Stashed changes
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
<<<<<<< Updated upstream
=======
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
>>>>>>> Stashed changes
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;


public class InterfaceRechercheController extends AbstractDAO implements Initializable
{

	@FXML
	private Button annulerButton, switchSceneButton,btnRecherche;
	@FXML
	private TableView<Document> documentTable;
	@FXML
	private TextField searchField;
	@FXML
	private TextField labelSearch1, labelSearch2;
	
    private ObservableList<Document> observableDocs ;
//    List<Document> listDoc = new LinkedList<Document>();
    
	private CtrlDocument ctrlDoc = new CtrlDocument();
<<<<<<< Updated upstream
=======
	private CtrlReference ctrlTag = new CtrlReference();
	private ObservableList<Document> observableDoc = FXCollections.observableArrayList();
//	private ObservableSet<String> suggestions = FXCollections.observableSet();
	//private SortedSet<Reference> tagSortedList ;

	
	public void enterTag1()
	{
		
		
		String query = "{CALL select_tags_documents(?,?)}";
		
		
		
		try 
		{
			CallableStatement stmt = connection.prepareCall(query);
			
			if(tag1.getText().isBlank())
			{
				stmt.setString(1, null);
				stmt.setString(2, tag2.getText());				
			}
			else if(tag2.getText().isBlank())
			{
				stmt.setString(1, tag1.getText());
				stmt.setString(2, null);				
			}
			else {
				stmt.setString(2, tag2.getText());
				stmt.setString(1, tag1.getText());
			}
			stmt.execute(); 
			
			//System.out.print("select_tags_documents successfull\n");
			Alert alert=new Alert(AlertType.CONFIRMATION,"select_tags_documents successfull",ButtonType.OK);
	    	alert.showAndWait();
			ResultSet rst = stmt.getResultSet();
			
			observableDoc.clear();
			
			while(rst.next())
			{	
				observableDoc.add(new Document(rst));
			}
			
			//observableDoc.forEach(i -> System.out.println("DOC: "+i.getNomDocument()));
			ctrlDoc.setListeDoc(observableDoc);
//			ctrlDoc.getListeDoc().forEach(i -> System.out.println("DOC: "+i.getNomDocument()));
				
		} 
		catch(Exception e)
		{
			
			//System.out.println("\nPROBLEME select_tags_documents enterTag1\n");
			Alert alert=new Alert(AlertType.ERROR,"PROBLEME select_tags_documents enterTag1",ButtonType.OK);
	    	alert.showAndWait();
			e.printStackTrace();
			e.getCause(); 
		}
	}
>>>>>>> Stashed changes
	
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
	public void  onActionRecherche() {
		
		documentTable.getItems().clear();
		
		documentTable=new TableView<Document>();
		observableDocs = FXCollections.observableArrayList();
		getAll();
		documentTable.setItems(observableDocs);
		observableDocs.addAll(getAll());
		
		
	}
	public List<Document> getAll(){
		
		List<Document>  list =new ArrayList<Document>();
		Connection connectDb = DatabaseConnection.getInstance().getConnection();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql="select * from utilisateur";
		try {
			 pst=connectDb.prepareStatement(sql);
			System.out.println("succes d'exce de la connection");
			rs=pst.executeQuery();
			while(rs.next())
			{					 
				
				  Document u =new Document(rs);
				 
			}
			pst.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	
	
}
	
	}

