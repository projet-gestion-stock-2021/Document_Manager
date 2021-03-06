package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.SortedSet;

import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;

import AutoCompletionComponent.AutocompleteMultiSelectionBox;
import ctrlEntites.CtrlDocument;
import ctrlEntites.CtrlDossier;
import ctrlEntites.CtrlTypeDoc;
import ctrlEntites.CtrlTypeDossier;
import entity.Document;
import entity.TypeDeDocument;
import entity.Utilisateur;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import entity.Reference;
import ctrlEntites.CtrlReference;

public class InterfaceRechercheController implements Initializable
{

	@FXML
	private Button annulerButton, switchSceneButton;
	@FXML
	private TableView<Document> documentTable;
	@FXML
	private TextField searchField;
	@FXML
	private CustomTextField tag1;
	@FXML
	private CustomTextField tag2;
	
    //public ObservableList<Document> observableDocs = FXCollections.observableArrayList();
//    List<Document> listDoc = new LinkedList<Document>();
    
	private CtrlDocument ctrlDoc = new CtrlDocument();
	private CtrlReference ctrlTag = new CtrlReference();
	private ObservableList<Document> observableDoc = FXCollections.observableArrayList();
//	private ObservableSet<String> suggestions = FXCollections.observableSet();
	//private SortedSet<Reference> tagSortedList ;

	
	public void enterTag1()
	{
		Connection connectDb = DatabaseConnection.getInstance().getConnection();
		
		String query = "{CALL select_tags_documents(?,?)}";
		
		//TextFields;
		
		try 
		{
			CallableStatement stmt = connectDb.prepareCall(query);
			
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
			else
			{
				stmt.setString(1, tag1.getText());
				stmt.setString(2, tag2.getText());	
				
			}

			stmt.execute(); 
			
			System.out.print("select_tags_documents successfull\n");
			
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
			
			System.out.println("\nPROBLEME select_tags_documents enterTag1\n");
			e.printStackTrace();
			e.getCause(); 
		}
	}
	
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
		
		//ok ??a cr??e bien une colonne avec le bon nom
		TableColumn<Document, String> col_DocumentName = new TableColumn<Document, String>("Nom document");
		TableColumn<Document, String> col_DocumentDate = new TableColumn<Document, String>("Date de scan");
		TableColumn<Document, String> col_DocumentLastModified = new TableColumn<Document, String>("Derniere modification");
		TableColumn<Document, Number> col_level = new TableColumn<Document, Number>("Level");
		//TableColumn<Document, String> col_DocumentPath = new TableColumn<Document, String>("Chemin");
		
		documentTable.getColumns().setAll(col_DocumentName, col_DocumentDate, col_DocumentLastModified, col_level);
		
		//ENFIN!!!!!! le nom du doc s'affiche dans la colonne, Merci Oracle!
		col_DocumentName.setCellValueFactory(new Callback<CellDataFeatures<Document, String>, ObservableValue<String>>() 
		{
		     public ObservableValue<String> call(CellDataFeatures<Document, String> p) 
		     {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return p.getValue().documentNameProperty();
		     }
		  });
		
		
		col_DocumentDate.setCellValueFactory(new Callback<CellDataFeatures<Document, String>, ObservableValue<String>>() 
		{
		     public ObservableValue<String> call(CellDataFeatures<Document, String> p) 
		     {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return p.getValue().documentDateScanProperty();
		     }
		  });
		
		col_DocumentLastModified.setCellValueFactory(new Callback<CellDataFeatures<Document, String>, ObservableValue<String>>() 
		{
		     public ObservableValue<String> call(CellDataFeatures<Document, String> p) 
		     {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return p.getValue().documentDateModifiedProperty();
		     }
		  });
		
		col_level.setCellValueFactory(new Callback<CellDataFeatures<Document, Number>, ObservableValue<Number>>() 
		{
		     public ObservableValue<Number> call(CellDataFeatures<Document, Number> p) 
		     {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return  p.getValue().level();
		     }
		  });
		customiseFactory(col_level);
		
		//double-click on document to open it
		documentTable.setRowFactory( tv -> {
		    TableRow<Document> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		        	Document rowData = row.getItem();
		           	if(!Desktop.isDesktopSupported())
		        	{
		        		System.out.println("Desktop is not supported");
		        		return;
		        	}
		        	//selectedDoc = (Document) listViewAffiche.getSelectionModel().getSelectedItem();
		        	Desktop desktop = Desktop.getDesktop();
		        	
		        	
		        	if(Files.exists(Paths.get(rowData.getPathScan()))) 
		        	{
		        		try {
		        			if(rowData.getId_user() == Utilisateur.getConnectedUser().getIdUtilisateur())
		    				desktop.open(Paths.get(rowData.getPathScan()).toFile());
		        			else
		        				System.out.println("\nUtilisateur n'a pas les droits sur ce fichier\n");
		    				//System.out.println("\n"+rowData.getPathScan()+"\n");
		    			} catch (IOException e) {
		    				// TODO Auto-generated catch block
		    				e.printStackTrace();
		    			}
		        	}
		        	else
		        	{
		        		System.out.println("\nFILE DOESN'T EXIST!!!!\n");
		        		System.out.println(rowData.getPathScan());
		        	}
		            System.out.println(rowData);
		        }
		    });
		    return row ;
		});
		
		
		try 
		{
			ctrlDoc.charger();
			ctrlTag.charger();
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ctrlDoc.getListeDoc().forEach(i -> System.out.println("DOC: "+i.getNomDocument()));
		
		//ultra redondant 
		observableDoc.addAll(ctrlDoc.getListeDoc());
		documentTable.setItems(observableDoc);
		
		//AUTOCOMPLETION TEXTFIELD controlsfx (librairie rajout??e dans eclipse et scenebuilder)
		TextFields.bindAutoCompletion(tag1,ctrlTag.getListeDossier());
		TextFields.bindAutoCompletion(tag2,ctrlTag.getListeDossier());

		//Listener on observableList, to refresh the tableview when list change
		observableDoc.addListener(new ListChangeListener<Document>(){

            @Override
            public void onChanged(Change<? extends Document> pChange) 
            {
                documentTable.refresh();
            }

        });
		
	}
	
	//CHANGE COLOR OF A COLUMN, access level?
	private void customiseFactory(TableColumn<Document, Number> calltypel) {
	    calltypel.setCellFactory(column -> {
	        return new TableCell<Document, Number>() {
	            @Override
	            protected void updateItem(Number item, boolean empty) {
	                super.updateItem(item, empty);

	                setText(empty ? "" : getItem().toString());
	                setGraphic(null);

	                TableRow<Document> currentRow = getTableRow();

	                if (!isEmpty()) {

	                    if(item.equals(Utilisateur.getConnectedUser().getIdUtilisateur())) 
	                        currentRow.setStyle("-fx-background-color:lightcoral");
	                    else
	                        currentRow.setStyle("-fx-background-color:lightgreen");
	                }
	            }
	        };
	    });
	}
	
	
}
