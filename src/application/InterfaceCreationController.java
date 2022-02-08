package application;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;

import entity.Document;
import entity.Dossier;
import entity.Parametre;
import entity.Reference;
import entity.Scan;
import entity.TypeDeDocument;
import entity.TypeDossier;
import entity.Utilisateur;
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
	private Button bnt_categorie;
	@FXML
	private Button openButton;
	@FXML
	private Button validerButton;
	@FXML
	private TextArea textarea;
	@FXML
	private Label labelPath;
	@FXML
	private Label pathCategorie;
	@FXML
	private TextField nomDoc;
	@FXML
	private CustomTextField tagPerso1;
	@FXML
	private CustomTextField tagPerso2;
	@FXML
	private ChoiceBox tag_typeDossier;
	@FXML
	private ChoiceBox tag_dossier;
	@FXML
	private ChoiceBox tag_typeDocument;
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
    
    Scan scanPath = new Scan();
    Parametre pathStockage = new Parametre();
    
    /*
     * Create the path with the 3 categories if it doesn't exist.
     * And it copies the file selected in this path.
     */
    public void createPathAndCopy()
    {
    	String path ="";
    	

    	//Creation du dossier
    	
    	try 
    	{
    		if(!Files.exists(Paths.get(scanPath.getpathScan().toString())))
    		{
    			Files.createDirectories(Paths.get(scanPath.getpathScan().toString()));
    		}
    		else System.out.print("\nPath already exists\n");
		} 
    	catch (IOException e) 
    	{
    		System.out.print("\nPROBLEM creating path\n");
			e.printStackTrace();
		}
    	
    	//Copie du fichier
    	
    	try 
    	{
    		path = scanPath.getpathScan().toString() +"\\" +selectedDoc.getNomDocument();
    		
    		if(!Files.exists(Paths.get(path)))
			Files.copy(selectedDoc.getDocPath(), Paths.get(path));
    		else 
    		System.out.print("\nFile already exists\n");
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
    	//j'ai insert dans le mauvais ordre!!!!
		Connection connectDb = DatabaseConnection.getInstance().getConnection();
		int lastID_Doc = 0;
		String query = "";
	
		/*
		query = "{CALL insert_dossier(?,?)}";
		
		
		try 
		{
			CallableStatement stmt = connectDb.prepareCall(query);

			selectedDossier = (Dossier) tag_dossier.getSelectionModel().getSelectedItem();
			selectedTypeDossier = (TypeDossier) tag_typeDossier.getSelectionModel().getSelectedItem();
			System.out.print("***typeDossier: "+ tag_typeDossier.getSelectionModel().getSelectedItem().toString() +"\n");
			
			stmt.setString(1, selectedDossier.getNomDossier());
			stmt.setInt(2, selectedTypeDossier.getIdTypeDossier());

			stmt.execute(); 
			System.out.print("uploaded dossier successfully\n");
				
		} 
		catch(Exception e)
		{
			System.out.println("\nPROBLEME insert_dossier validerOnClicked\n");
		}
		
		query = "{CALL insert_type_de_document(?,?)}";		
		
		try 
		{
			CallableStatement stmt = connectDb.prepareCall(query);

			selectedTypeDoc = (TypeDeDocument) tag_typeDocument.getSelectionModel().getSelectedItem();
			selectedDossier = (Dossier) tag_dossier.getSelectionModel().getSelectedItem();
			System.out.print("***Dossier: "+ tag_dossier.getSelectionModel().getSelectedItem().toString() +"\n");
			
			stmt.setString(1, selectedTypeDoc.getNomTypeDoc());
			stmt.setInt(2, selectedDossier.getIdDossier());

			stmt.execute(); 
			System.out.print("uploaded type_de_document successfully\n");
				
		} 
		catch(Exception e)
		{
			System.out.println("\nPROBLEME insert_type_de_document validerOnClicked\n");
		}
		*/
		
		
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
		      
			System.out.print("uploaded tag_perso1 and tag_perso2 successfully lastID_Ref: " + lastID_Ref1 +"\n");
				
		} 
		catch(Exception e)
		{
			System.out.println("\nPROBLEME insert_reference validerOnClicked\n");
		}
		
    	//Creation du path gr�ce aux categories declaration du scan
    	if(tag_typeDocument.getSelectionModel().isEmpty())
    	{
    		scanPath.setpathScan(
    				pathStockage.getPathStock()+ "\\" 
    				+ tag_typeDossier.getSelectionModel().getSelectedItem().toString()+ "\\"
    				+ tag_dossier.getSelectionModel().getSelectedItem().toString());
    	}
    	else if(tag_dossier.getSelectionModel().isEmpty() && tag_typeDocument.getSelectionModel().isEmpty())
    	{
    		scanPath.setpathScan(
    				pathStockage.getPathStock()+ "\\" 
    				+ tag_typeDossier.getSelectionModel().getSelectedItem().toString());
    	}
    	else if(tag_typeDossier.getSelectionModel().isEmpty() && tag_dossier.getSelectionModel().isEmpty() && tag_typeDocument.getSelectionModel().isEmpty())
    	{
    		//MESSAGE POPUP choisir les cat�gories
    		System.out.print("\nCHOOSE CATEGORIES\n");
    	}
    	else
    	{
    		scanPath.setpathScan(
    				pathStockage.getPathStock()+ "\\" 
    				+ tag_typeDossier.getSelectionModel().getSelectedItem().toString()+ "\\"
    				+ tag_dossier.getSelectionModel().getSelectedItem().toString()+ "\\"
    				+ tag_typeDocument.getSelectionModel().getSelectedItem().toString());
    	}
    	
		/*
		 * INSERT DOCUMENT IN BEFORE LAST
		 */
		query = "{CALL insert_document(?,?,?,?,?,?)}";
		
		try 
		{
			CallableStatement stmt = connectDb.prepareCall(query);
			stmt.setString(1, selectedDoc.getNomDocument());//Nom Document
			
			Date date = new Date();
			
			long timeInMilliSeconds = selectedDoc.getDateDocument().toMillis();
			java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
			
			stmt.setDate(2,date1);//Date Document
			stmt.setInt(3, Utilisateur.getConnectedUser().getIdUtilisateur());
			
			//selectedTypeDoc = (TypeDeDocument) tag_typeDocument.getSelectionModel().getSelectedItem();
			//System.out.print("***typeDocument: "+ tag_typeDocument.getSelectionModel().getSelectedItem().toString() +"\n");
			
			//stmt.setInt(4, selectedTypeDoc.getIdTypeDeDocument());
			stmt.setInt(4, 3);
			stmt.registerOutParameter(5,Types.INTEGER);
			
			stmt.setString(6, scanPath.getpathScan().toString() +"\\" +selectedDoc.getNomDocument());
			
			stmt.execute(); 
			
			lastID_Doc = stmt.getInt(5);
			
			System.out.print("uploaded doc successfully\n");
			
			
		} 
		catch(Exception e)
		{
			System.out.println("\nPROBLEME insert_document validerOnClicked\n");
			
		}
		
		query = "{CALL insert_reference(?,?)}";
		
		
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
		      
			System.out.print("uploaded tag_perso1 and tag_perso2 successfully lastID_Ref: " + lastID_Ref1 +"\n");
				
		} 
		catch(Exception e)
		{
			System.out.println("\nPROBLEME insert_reference validerOnClicked\n");
		}
		
		/*
		 * INSERT PIVOt in last
		 */
		query = "{CALL insert_typer(?,?)}";//insert table pivot pour lier le document enregistré et les tags
		
		
		try 
		{
			CallableStatement stmt = connectDb.prepareCall(query);
			
			//tag_dossier
			stmt.setInt(2, lastID_Ref1);
			stmt.setInt(1, lastID_Doc);
			stmt.execute();
			
			//tag_typeDossier
			stmt.setInt(2, lastID_Ref1 - 1);
			stmt.setInt(1, lastID_Doc);
			stmt.execute();
			
			System.out.print("uploaded typer pivot\n");
				
		} 
		catch(Exception e)
		{
			System.out.println("\nPROBLEME insert_typer validerOnClicked\n");

		}
		
		query = "{CALL insert_scan_with_level(?,?,?)}";
		
		
		try 
		{
			CallableStatement stmt = connectDb.prepareCall(query);
			int lastID = 0;
			stmt.setString(1, scanPath.getpathScan().toString());
			stmt.setInt(2,Utilisateur.getConnectedUser().getIdUtilisateur());
			stmt.registerOutParameter(3,Types.INTEGER);
			stmt.execute();
			
			lastID = stmt.getInt(3);
		      
			System.out.print("uploaded sacnPath successfully\n");
				
		} 
		catch(Exception e)
		{
			System.out.println("\nPROBLEME insert_scan_with_level validerOnClicked\n");
		}

		
		this.createPathAndCopy();
		listDoc.remove(listViewAffiche.getSelectionModel().getSelectedIndex());
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
			ctrlDoc.charger();
			ctrlDossier.charger();
			ctrlTypeDoc.charger();
			ctrlTypeDossier.charger();
			ctrlTag.charger();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.tag_typeDocument.setItems(ctrlTypeDoc.getListeTypeDoc());
		this.tag_dossier.setItems(ctrlDossier.getListeDossier());//à refaire, porte à confusion
		this.tag_typeDossier.setItems(ctrlTypeDossier.getListeTypeDossier());//à refaire, porte à confusion
		
		TextFields.bindAutoCompletion(tagPerso1,ctrlTag.getListeDossier());
		TextFields.bindAutoCompletion(tagPerso2,ctrlTag.getListeDossier());
		
	}

    /*
     * Opens the file selected in the list.
     */
    public void onListCellClicked()//� renommer
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
     * Browse Button click.
     * 
     * @param event
     * @throws Exception 
     */
	@FXML
	private void handleDirectory(ActionEvent event) throws Exception //� renommer
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
	private void browsePathStockage()
	{
	    DirectoryChooser directoryChooser = new DirectoryChooser();
	    pathStockage.setPathStock(directoryChooser.showDialog(null).toString());
	    
	    if (pathStockage.getPathStock() == null) 
	    {
	    	pathCategorie.setText("No Directory selected");
	    }
	    else 
	    {
	    	pathCategorie.setText(pathStockage.getPathStock());
	    }
	}
	
	@FXML
	private void checkBoxSetOnAction() throws Exception
	{
		clearListView();
		dircount = 0;
		filecount = 0;
		showListFiles(selectedDirectory);
		
	}
	
	
	/**
	 * Show list of all files in a directory, recursively or not
	 * @param directoryPath
	 * @throws Exception 
	 */
	private void showListFiles(File directoryPath) throws Exception
	{
		
		if (directoryPath != null) 
    		{
				File[] files = directoryPath.listFiles();
				String tempPath = null;
				
				for(int i = 0; i < files.length; i++)
				{
					tempPath = null;
					
					if (files[i].isDirectory() == true) 
					{
						//listViewAffiche.getItems().add(files[i].getName());
	                    //System.out.println("Dossier: " + files[i].getAbsolutePath());
	                    this.dircount++;
	                } 
					else 
	                {
						//Normalement je devrais comparer que les fichiers qui ne sont pas dans la DB
						//en chargeant le CtrlDoc et en comparant les noms des fichiers
						//mais je vais directement comparer les checksum
						//faudrait peut-�tre stocker le checksum dans la DB pour aller plus vite
						
						Connection connexion = DatabaseConnection.getInstance().getConnection();
						try 
						{							
							CallableStatement stmt = connexion.prepareCall("{call search_document(?,?)}"); 
							
							stmt.setString(1, files[i].getName());
							stmt.registerOutParameter(2,Types.VARCHAR);
							stmt.execute();

							//resultset
							
							tempPath = stmt.getString(2);
							//System.out.print(tempPath+"\n");
								
						} 
						catch(Exception e)
						{
							
							System.out.println("\nPROBLEME showListFiles {call search_document_by_name(?,?)}\n");
							e.printStackTrace();
							e.getCause(); 
						}

//						//Compare Checksum
//						if(tempPath != null)
//						{
//							tempPath = pathStockage.getPathStock() +"\\"+ tempPath;							
//						}
						System.out.print(tempPath+" found in DB doesn't exists yet in directory path!"+"\n");
//						MD5Checksum.getMD5Checksum(files[i].toPath().toAbsolutePath().toString());
//						MD5Checksum.getMD5Checksum(tempPath);
						
						if(tempPath != null && Files.exists(Paths.get(tempPath)))
						{
							if(MD5Checksum.getMD5Checksum(files[i].toPath().toAbsolutePath().toString()) 
									== MD5Checksum.getMD5Checksum(tempPath))
							{
								System.out.println("\nMEME FICHIER non modifie\n");
							}
							else
							{
								System.out.println("\nMEME nom de FICHIER peut-etre modifie\n");
							}
							
						}
						else
						{
							listDoc.add(new Document(files[i].toPath().toAbsolutePath()));
							observableDocs.add(new Document(files[i].toPath().toAbsolutePath()));							
						}
						
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
