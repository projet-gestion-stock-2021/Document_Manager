package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application2.AbstractDAO;
import entity.Niveau;

/**
 * Controller of the signIn Window. The main purpose of this Controller is to create a new user.
 * 
 * @author Neil
 *
 */
public class SignInController extends AbstractDAO implements Initializable
{
	@FXML
	private Button annuler;
	@FXML
	private Button valider;
	@FXML
	private TextField nom;
	@FXML
	private TextField prenom;
	@FXML
	private TextField login;
	@FXML
	private PasswordField mdp;
	@FXML
	private ComboBox<Niveau> niveau;
	
	private Niveau niv;
	
	/**
	 * On validation, when the button is clicked, it "takes" all the data in the textFields and ComboBox
	 * and put them in a callableStatement to insert a user in the database.
	 * @param event
	 */
	public void validate(ActionEvent event)
	{	
		//Connection connectDb = DatabaseConnection.getInstance().getConnection();
		
		String query = "{CALL insert_utilisateur(?,?,?,?,?)}";
		
		
		try 
		{
			CallableStatement stmt = connection.prepareCall(query);
			stmt.setString(1, nom.getText().trim());
			stmt.setString(2, prenom.getText().trim());
			stmt.setString(3, login.getText().trim());
			stmt.setString(4, mdp.getText());

			stmt.setInt(5, niv.getIdNiveau());
			
			stmt.execute(); 
			System.out.print("uploaded successfully\n");
				
		} 
		catch(Exception e)
		{
			
			System.out.println("\ninsert_utilisateur NAN\n");
			System.out.print(niveau.getSelectionModel().getSelectedItem().getIdNiveau());//vide?
			e.printStackTrace();
			e.getCause(); 
		}
	}
	
	/**
	 * When the cancel button is clicked, the window "signIn.fxml" closes and "LoginView.fxml" opens back.
	 * @param event
	 */
	public void cancel(ActionEvent event) 
	{
		Stage stage = (Stage) annuler.getScene().getWindow();
		stage.close();
		
		try 
		{
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("LoginView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			stage.setScene(scene);
			stage.show();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			e.getCause();
		}
	}

	/**
	 * Initialize the ComboBox containing the "level names" of the user.
	 * It makes a call to the database and fill the ComboBox with data from the "niveau" table and fill the Niveau() class objects. 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		//LISTENER when value changes
		niveau.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
			 niv = niveau.getSelectionModel().getSelectedItem();
			   System.out.println(newValue + " " + newValue.getIdNiveau());
			}); 
		
//		niveau.setConverter(new StringConverter<Niveau>() 
//		{
//			
//			@Override
//			public String toString(Niveau object) {
//				return object.getNomNiveau();
//			}
//			
//			@Override
//			public Niveau fromString(String string) {
//				return niveau.getItems().stream().filter(ap -> 
//				ap.getNomNiveau().equals(string)).findFirst().orElse(null);
//			}
//		});
		

		// TODO Auto-generated method stub
		ObservableList<Niveau> listNiveau = FXCollections.observableArrayList();
		
		//Connection connectDb = DatabaseConnection.getInstance().getConnection();
		
		String query = "{CALL select_niveau()}";
	
		
		try 
		{
			
			//Statement statement = connectDb.createStatement();
			CallableStatement stmt = connection.prepareCall(query);
			
			ResultSet queryResult = stmt.executeQuery();
			
			
			
			//int i =0;
					
			while(queryResult.next()) 
			{
				Niveau temp = new Niveau();
				temp.setIdNiveau(queryResult.getInt("Id_Niveau")) ;
				temp.setNomNiveau(queryResult.getString("Nom_Niveau"));
				listNiveau.add(temp);
				//La liste se rempli bien
				//System.out.println("\n"+ listNiveau.get(i).getNomNiveau());
				//i++;
			}
				
		} 
		catch(Exception e)
		{
			
			System.out.println("\nProblem PopulateCombobox\n");
			e.printStackTrace();
			e.getCause(); 
		}
		
		niveau.getItems().addAll(listNiveau);
		

	}
	
}
