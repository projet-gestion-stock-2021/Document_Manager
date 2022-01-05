package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.ComboBox;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Niveau;

public class SignInController 
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
	private static ComboBox<Niveau> niveau;
	
	public static void populateCombobox()
	{
		ObservableList<Niveau> listNiveau = FXCollections.observableArrayList();
		
		Connection connectDb = DatabaseConnection.getInstance().getConnection();
		
		String query = "{CALL select_niveau()}";
		
		niveau = new ComboBox<Niveau>();
		
		try 
		{
			
			//Statement statement = connectDb.createStatement();
			CallableStatement stmt = connectDb.prepareCall(query);
			
			ResultSet queryResult = stmt.executeQuery();
			
			Niveau temp = new Niveau();
					
			while(queryResult.next()) 
			{
				temp.setIdNiveau(queryResult.getInt("Id_Niveau"));
				temp.setNomNiveau(queryResult.getString("Nom_Niveau"));
				listNiveau.add(temp);
				//La liste se rempli bien
				//System.out.println("\n"+ listNiveau.get(temp.getIdNiveau()-1).getNomNiveau());
				niveau.getItems().add(temp);
				
			}
				
		} 
		catch(Exception e)
		{
			
			System.out.println("\nProblem PopulateCombobox\n");
			e.printStackTrace();
			e.getCause(); 
		}
		//niveau.setItems(listNiveau);
	}
	
	public void validate(ActionEvent event)
	{	
		Connection connectDb = DatabaseConnection.getInstance().getConnection();
		
		String query = "{CALL insert_utilisateur(?,?,?,?,?)}";
		
		try 
		{
			CallableStatement stmt = connectDb.prepareCall(query);
			stmt.setString(1, nom.getText().trim());
			stmt.setString(2, prenom.getText().trim());
			stmt.setString(3, login.getText().trim());
			stmt.setString(4, mdp.getText());
			stmt.setInt(5, 1);
			//stmt.setInt(5, niveau.getValue().getIdNiveau());
			
			stmt.execute(); 
			System.out.print("uploaded successfully\n");
				
		} 
		catch(Exception e)
		{
			
			System.out.println("\ninsert_utilisateur NAN\n");
			e.printStackTrace();
			e.getCause(); 
		}
	}
	
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
	
}
