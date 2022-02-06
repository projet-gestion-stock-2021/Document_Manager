package application;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.*;

import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import entity.Document;
import entity.Dossier;
import entity.Reference;
import entity.Scan;
import entity.TypeDeDocument;
import entity.TypeDossier;
import ctrlEntites.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
//import javax.security.auth.callback.Callback;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.stage.DirectoryChooser;
import java.awt.Desktop;


public class InterfaceCreationController implements Initializable
{
	
	
	// Parametres fxml
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private Button annulerButton;
	@FXML
	private Button bnt_browser;
	@FXML
	private Button openButton;
	@FXML
	private Button validerButton;
	@FXML
	private TextArea textarea;
	@FXML
	private Label labelPath;
	@FXML
	private TextField nomDoc;
	@FXML
	private CustomTextField tagPerso1;
	@FXML
	private CustomTextField tagPerso2;
	@FXML
	private ChoiceBox tag1;
	@FXML
	private ChoiceBox tag2;
	@FXML
	private ChoiceBox tag3;
    @FXML
	private DatePicker dateC;
    @FXML
    private CheckBox recursiveCheckBox;
   
    @FXML
    private Label nbfiles;
    @FXML
    private Label nbfolders;
//    @FXML
//    private Button clearList;
    
    @FXML
    private ListView listViewAffiche;
    
    @FXML
    private TableView<Document> tabView;
//    @FXML
//    private TableColumn<Document,String> docNamecol;
//    
//    
    public ObservableList<Document> observableDocs = FXCollections.observableArrayList();
    List<Document> listDoc = new LinkedList<Document>();
    
	private CtrlDocument ctrlDoc = new CtrlDocument();
	private CtrlDossier ctrlDossier = new CtrlDossier();
	private CtrlTypeDossier ctrlTypeDossier = new CtrlTypeDossier();
	private CtrlTypeDoc  ctrlTypeDoc = new CtrlTypeDoc();
	private CtrlScan ctrlScan = new CtrlScan();
	private CtrlReference ctrlTag = new CtrlReference();

    
    private File selectedDirectory;
    public int filecount = 0;
    public int dircount = 0;
    
    Document selectedDoc;
    
    TypeDeDocument selectedTypeDoc;
    TypeDossier selectedTypeDossier;
    Dossier selectedDossier;
    
    Reference ref;
    
    /*
     * Create the path with the 3 categories if it doesn't exist.
     * And it copies the file selected in this path.
     */
    public void createPathAndCopy()
    {
    	String path = null;
    	
    	if(tag3.getSelectionModel().isEmpty())
    	{
    		path = "..\\" + tag1.getSelectionModel().getSelectedItem().toString()+ "\\"
    				+ tag2.getSelectionModel().getSelectedItem().toString();
    	}
    	else if(tag2.getSelectionModel().isEmpty() && tag3.getSelectionModel().isEmpty())
    	{
    		path = "..\\" + tag1.getSelectionModel().getSelectedItem().toString();
    	}
    	else if(tag1.getSelectionModel().isEmpty() && tag2.getSelectionModel().isEmpty() && tag3.getSelectionModel().isEmpty())
    	{
    		//MESSAGE POPUP choisir les cat�gories
    		System.out.print("\nCHOOSE CATEGORIES\n");
    	}
    	else
    	{
    		path = "..\\" + tag1.getSelectionModel().getSelectedItem().toString()+ "\\"
    				+ tag2.getSelectionModel().getSelectedItem().toString()+ "\\"
    				+ tag3.getSelectionModel().getSelectedItem().toString();
    	}
    	
    	Scan scanPath = new Scan();
    	
    	try 
    	{
    		if(!Files.exists(Paths.get(path)))
    		{
    			Files.createDirectories(Paths.get(path));
    			scanPath.setpathScan(path);
    		}
    		else System.out.print("\nPath already exists\n");
		} 
    	catch (IOException e) 
    	{
    		System.out.print("\nPROBLEM creating path\n");
			e.printStackTrace();
		}
    	
    	try 
    	{
    		path += "\\" +selectedDoc.getNomDocument();
    		
    		if(!Files.exists(Paths.get(path)))
			Files.copy(selectedDoc.getDocPath(), Paths.get(path));
    		else System.out.print("\nFile already exists\n");
		} 
    	catch (IOException e) 
    	{
    		System.out.print("\nPROBLEM copy file to path\n");
			e.printStackTrace();
		}
    }
    
    /*
     * When the file in the list is validated with tags and categories,
     * it sends values from textfields, combobox and the document to the DB.
     */
    public void validerOnClicked()
    {
		Connection connectDb = DatabaseConnection.getInstance().getConnection();
		
		String query = "{CALL insert_document(?,?,?,?,?)}";
		
		int lastID_Doc = 0;
		
		try 
		{
			CallableStatement stmt = connectDb.prepareCall(query);
			//OPEN THE DOC FIRST, I WILL CHANGE THE METHOD THEN
			stmt.setString(1, selectedDoc.getNomDocument());//Nom Document
			
	        Date date = new Date();

	        long timeInMilliSeconds = selectedDoc.getDateDocument().toMillis();
	        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
	        
			stmt.setDate(2,date1);//Date Document
			stmt.setInt(3, 1);//CreationDoc ID
			
			selectedTypeDoc = (TypeDeDocument) tag1.getSelectionModel().getSelectedItem();
			stmt.setInt(4, selectedTypeDoc.getIdTypeDeDocument());
			stmt.registerOutParameter(5,Types.INTEGER);

			stmt.execute(); 
			
			lastID_Doc = stmt.getInt(5);
			
			System.out.print("uploaded doc successfully\n");
			
				
		} 
		catch(Exception e)
		{
			
			System.out.println("\nPROBLEME insert_document validerOnClicked\n");
			e.printStackTrace();
			e.getCause(); 
		}
		
		query = "{CALL insert_type_de_document(?,?)}";
		
		
		try 
		{
			CallableStatement stmt = connectDb.prepareCall(query);

			selectedTypeDoc = (TypeDeDocument) tag1.getSelectionModel().getSelectedItem();
			selectedDossier = (Dossier) tag2.getSelectionModel().getSelectedItem();
			
			stmt.setString(1, selectedTypeDoc.getNomTypeDoc());
			stmt.setInt(2, selectedDossier.getIdDossier());

			stmt.execute(); 
			System.out.print("uploaded type_de_document successfully\n");
				
		} 
		catch(Exception e)
		{
			
			System.out.println("\nPROBLEME insert_type_de_document validerOnClicked\n");
			e.printStackTrace();
			e.getCause(); 
		}
		
		query = "{CALL insert_dossier(?,?)}";
		
		
		try 
		{
			CallableStatement stmt = connectDb.prepareCall(query);

			selectedDossier = (Dossier) tag2.getSelectionModel().getSelectedItem();
			selectedTypeDossier = (TypeDossier) tag3.getSelectionModel().getSelectedItem();
			
			stmt.setString(1, selectedDossier.getNomDossier());
			stmt.setInt(2, selectedTypeDossier.getIdTypeDossier());

			stmt.execute(); 
			System.out.print("uploaded dossier successfully\n");
				
		} 
		catch(Exception e)
		{
			
			System.out.println("\nPROBLEME insert_dossier validerOnClicked\n");
			e.printStackTrace();
			e.getCause(); 
		}
		
		query = "{CALL insert_reference(?,?)}";
		int lastID_Ref1 = 0;
		
		try 
		{
			CallableStatement stmt = connectDb.prepareCall(query);
			
			stmt.setString(1, tagPerso1.getText());
			stmt.registerOutParameter(2,Types.INTEGER);
			stmt.execute();
			
			stmt.setString(1, tagPerso2.getText());
			stmt.registerOutParameter(2,Types.INTEGER);
			stmt.execute();
			
			lastID_Ref1 = stmt.getInt(2);
		      
			System.out.print("uploaded tag1 and tag2 successfully lastID_Ref: " + lastID_Ref1 +"\n");
				
		} 
		catch(Exception e)
		{
			
			System.out.println("\nPROBLEME insert_reference validerOnClicked\n");
			e.printStackTrace();
			e.getCause(); 
		}
		
		
		query = "{CALL insert_typer(?,?)}";//insert table pivot pour lier le document enregistré et les tags
		
		
		try 
		{
			CallableStatement stmt = connectDb.prepareCall(query);
			
			//tag2
			stmt.setInt(2, lastID_Ref1);
			stmt.setInt(1, lastID_Doc);
			stmt.execute();
			
			//tag1
			stmt.setInt(2, lastID_Ref1 - 1);
			stmt.setInt(1, lastID_Doc);
			stmt.execute();
			
			System.out.print("uploaded typer pivot\n");
				
		} 
		catch(Exception e)
		{
			
			System.out.println("\nPROBLEME insert_typer validerOnClicked\n");
			e.printStackTrace();
			e.getCause(); 
		}
		
		this.createPathAndCopy();
		//listDoc.remove(listViewAffiche.getSelectionModel().getSelectedIndex());
		listViewAffiche.getItems().remove(listViewAffiche.getSelectionModel().getSelectedItem());//OK ça marche
		listViewAffiche.refresh();
    }
    
    /*
     * Called when the Controller is called (when the window InterfaceCreation opens).
     * In it, the entities are charged in Observable lists and the behaviour of ListView
     * is changed.
     */
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		//listener de listview, permet de reprendre le document selectionné
		listViewAffiche.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Document>() 
		{

		    @Override
		    public void changed(ObservableValue<? extends Document> observable, Document oldValue, Document newValue) {
		        // Your action here
		    	selectedDoc = (Document) listViewAffiche.getSelectionModel().getSelectedItem();
		    	
		        System.out.println("Selected item: " + newValue);
		    }
		});
				
		//ok ça crée bien une colonne avec le bon nom
		TableColumn<Document, String> col_DocumentName = new TableColumn<Document, String>("File Name");
		tabView.getColumns().setAll(col_DocumentName);
		
		//ENFIN!!!!!! le nom du doc s'affiche dans la colonne, Merci Oracle!
		col_DocumentName.setCellValueFactory(new Callback<CellDataFeatures<Document, String>, ObservableValue<String>>() 
		{
		     public ObservableValue<String> call(CellDataFeatures<Document, String> p) 
		     {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return p.getValue().documentNameProperty();
		     }
		  });
		 
		
		try 
		{
//			ctrlDoc.charger();
			ctrlDossier.charger();
			ctrlTypeDoc.charger();
			ctrlTypeDossier.charger();
			ctrlTag.charger();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.tag1.setItems(ctrlTypeDoc.getListeTypeDoc());
		this.tag2.setItems(ctrlDossier.getListeTypeDossier());//à refaire, porte à confusion
		this.tag3.setItems(ctrlTypeDossier.getListeDossier());//à refaire, porte à confusion
		
		TextFields.bindAutoCompletion(tagPerso1,ctrlTag.getListeDossier());
		TextFields.bindAutoCompletion(tagPerso2,ctrlTag.getListeDossier());
		
	}

    /*
     * Opens the file selected in the list.
     */
    public void onListCellClicked()
    {
    	if(!Desktop.isDesktopSupported())
    	{
    		System.out.println("Desktop is not supported");
    		return;
    	}
    	//selectedDoc = (Document) listViewAffiche.getSelectionModel().getSelectedItem();
    	Desktop desktop = Desktop.getDesktop();
    	
    	
    	if(selectedDoc.getDocPath().toFile().exists()) 
    	{
    		try {
				desktop.open(selectedDoc.getDocPath().toFile().getAbsoluteFile());
				System.out.println("\n"+selectedDoc.getDocPath().toFile().getAbsoluteFile()+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else
    	{
    		System.out.println("\nFILE DOESN'T EXIST!!!!\n");
    		System.out.println(selectedDoc.getDocPath().toFile().getAbsoluteFile());
    	}

    }
    
    /**
     * Gets the directory path in a File object.
     * @param event
     */
	@FXML
	private void handleDirectory(ActionEvent event) 
	{
		//reset list and counts
		clearListView();
		dircount = 0;
		filecount = 0;
		
	    DirectoryChooser directoryChooser = new DirectoryChooser();
	    selectedDirectory = directoryChooser.showDialog(null);
	    
	    if (selectedDirectory == null) 
	    {
	    	nomDoc.setText("No Directory selected");
	    }
	    else 
	    {
	    	nomDoc.setText(selectedDirectory.getAbsolutePath());
	    	showListFiles(selectedDirectory);
	    }
	    
	}
	
	@FXML
	private void checkBoxSetOnAction()
	{
		clearListView();
		dircount = 0;
		filecount = 0;
		showListFiles(selectedDirectory);
		
	}
	
//	private Boolean compareFiles()
//	{
//		Files.asByteSource(file).hash(hashFunction);
//		Files.asB
//		return null;
//	}
//	
	/**
	 * Show list of all files in a directory, recursively or not
	 * @param directoryPath
	 */
	private void showListFiles(File directoryPath)
	{
		
		if (directoryPath != null) 
    		{
				File[] files = directoryPath.listFiles();
				
				for(int i = 0; i < files.length; i++)
				{
					if (files[i].isDirectory() == true) 
					{
						//listViewAffiche.getItems().add(files[i].getName());
	                    //System.out.println("Dossier: " + files[i].getAbsolutePath());
	                    this.dircount++;
	                } 
					else 
	                {
						listDoc.add(new Document(files[i].toPath().toAbsolutePath()));
						observableDocs.add(new Document(files[i].toPath().toAbsolutePath()));
						
						//listViewAffiche.getItems().add(listDoc.);
	                    //System.out.println("  Fichier: " + files[i].getName());
						
	                    this.filecount++;
	                }
	                if (files[i].isDirectory() == true && recursiveCheckBox.isSelected() == true) 
	                {
	                	showListFiles(files[i]);
	                }
			
				}
				
				listViewAffiche.getItems().addAll(listDoc);
				
				tabView.setItems(observableDocs);

    		}
    		else 
    		{
    			labelPath.setText("Le dossier n'est pas valide");
    		}
		nbfiles.setText("Number of files: "+ filecount);
		nbfolders.setText("Number of folders: "+ dircount);
	}
	
	/*
	 * Clear the list of all previous documents
	 */
	@FXML
	private void clearListView()
	{
		listDoc.clear();
		listViewAffiche.getItems().clear();
	}

	public void switchDashboard () 
	{
		try 
		{
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

}
