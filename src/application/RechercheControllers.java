package application;

import java.beans.Statement;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

import entity.Document;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

public class RechercheControllers implements Initializable  {


    @FXML
    private Button btnRecherche;
    @FXML
    private TableColumn<Document, String> nomdoc;
    @FXML
    private TableColumn<Document, LocalDate> datescan;

    @FXML
    private TableColumn<Document, LocalDate> dermodif;

    @FXML
    private TextField labelSearch1;

    @FXML
    private TextField labelSearch2;

    

    @FXML
    private TextField searchField;

    @FXML
    private Button switchSceneButton;

    @FXML
    private TableView<Document> tbview;
    public ObservableList<Document> data =  FXCollections.observableArrayList();
    @FXML
    void onActionRecherche() {

    }

    @FXML
    void searchdoc() {

    }

    @FXML
    void switchDashboard() {

    }

    @FXML
    void switchSceneOnAction() {

    }
    public void initialize(URL arg0, ResourceBundle arg1) {
    	Connection connectDb = DatabaseConnection.getInstance().getConnection();

		String query = "{CALL select_document}";

		try
		{

			
			CallableStatement stmt = connectDb.prepareCall(query);
			
			ResultSet queryResult = stmt.executeQuery();

			while(queryResult.next())
			{
				data.add(new Document(queryResult.getString("Nom_Document")
						,queryResult.getDate("DateDocument")
						,queryResult.getDate("DateScan")));
			
			}
				
		} catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		nomdoc.setCellValueFactory(new PropertyValueFactory<Document,String>("Nom_Document"));
		/*
		 * datescan.setCellValueFactory(new
		 * PropertyValueFactory<Document,Date>("DateDocument"));
		 * dermodif.setCellValueFactory(new
		 * PropertyValueFactory<Document,Date>("DateScan"));
		 */
   
    	
    }
	 {
		// TODO Auto-generated method stub
		
	}

}
