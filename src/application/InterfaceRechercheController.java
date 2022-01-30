package application;

import java.net.URL;
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

import ctrlEntites.CtrlDocument;
import ctrlEntites.CtrlDossier;
import ctrlEntites.CtrlTypeDoc;
import ctrlEntites.CtrlTypeDossier;
import entity.Document;
import entity.TypeDeDocument;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
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
	private TextField tag2;
	@FXML
	private TextField tag1;
	
    //public ObservableList<Document> observableDocs = FXCollections.observableArrayList();
//    List<Document> listDoc = new LinkedList<Document>();
    
	private CtrlDocument ctrlDoc = new CtrlDocument();
	private CtrlReference ctrlTag = new CtrlReference();
	private ObservableList<Document> observableDoc = FXCollections.observableArrayList();
	//private SortedSet<Reference> tagSortedList ;
	
	public void enterTag1()
	{
		Connection connectDb = DatabaseConnection.getInstance().getConnection();
		
		String query = "{CALL select_tags_documents(?,?)}";
		
		//TextFields;
		
		try 
		{
			CallableStatement stmt = connectDb.prepareCall(query);
			
			stmt.setString(1, tag1.getText());
			stmt.setString(2, tag2.getText());

			stmt.execute(); 
			
			System.out.print("select_tags_documents successfull\n");
			
			ResultSet rst = stmt.getResultSet();
			
			while(rst.next())
			{	
				observableDoc.add(new Document(rst));
			}
			
			observableDoc.forEach(i -> System.out.println("DOC: "+i.getNomDocument()));
			ctrlDoc.setListeDoc(observableDoc);
			ctrlDoc.getListeDoc().forEach(i -> System.out.println("DOC: "+i.getNomDocument()));
				
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
		
		//ok ça crée bien une colonne avec le bon nom
		TableColumn<Document, String> col_DocumentName = new TableColumn<Document, String>("Nom document");
		TableColumn<Document, String> col_DocumentDate = new TableColumn<Document, String>("Date de scan");
		TableColumn<Document, String> col_DocumentLastModified = new TableColumn<Document, String>("Dernière modification");
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
		ctrlDoc.getListeDoc().forEach(i -> System.out.println("DOC: "+i.getNomDocument()));
		documentTable.setItems(ctrlDoc.getListeDoc());
		
		ctrlTag.getListeDossier().forEach(i -> System.out.println("TAG: "+i.getNomReference()));
		
		//AUTO COMPLETE TEXTFIELD FOR TAGS
		//https://stackoverflow.com/questions/36861056/javafx-textfield-auto-suggestions
		//tagSortedList.addAll(ctrlTag.getListeDossier());
		
		AutoCompleteTextField<Reference> text = new AutoCompleteTextField<Reference>(ctrlTag.getListeDossier());
		
		text.getEntryMenu().setOnAction(e ->
		{
		    ((MenuItem) e.getTarget()).addEventHandler(Event.ANY, event ->
		    {
		         if (text.getLastSelectedObject() != null)
		         {
		            text.setText(text.getLastSelectedObject().toString());
		            System.out.println(text.getLastSelectedObject().getNomReference());
		         }
		    });
		});
		
		//Listener on observableList, to refresh the tableview when list change
		ctrlDoc.getListeDoc().addListener(new ListChangeListener<Document>(){

            @Override
            public void onChanged(javafx.collections.ListChangeListener.Change<? extends Document> pChange) 
            {
//                while(pChange.next()) 
//                {
//                    // Do your changes here
//                }
                documentTable.refresh();
            }

        });
		
		observableDoc.addListener(new ListChangeListener<Document>(){

            @Override
            public void onChanged(Change<? extends Document> pChange) 
            {
//                while(pChange.next()) 
//                {
//                    // Do your changes here
//                }
                documentTable.refresh();
            }

        });
		
	}
	
	
}
