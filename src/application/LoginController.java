package application;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import application.SignInController;
import entity.Utilisateur;

public class LoginController  
{

	@FXML
	private Button annulerButton;
	@FXML
	private Button signIn;
	@FXML
	private Button seConnecterButton;
	@FXML
	private Label donneeInvalideLabel;
	@FXML
	private TextField identifiantTextField;
	@FXML
	private PasswordField mdpTextField;
	@FXML
	private ImageView lockImageView;



	public void identifiantButtonOnAction (ActionEvent event)
	{


		if(!identifiantTextField.getText().isBlank() && !mdpTextField.getText().isBlank())
		{
			validationIdent();
		}
		else
		{
			donneeInvalideLabel.setText("Entrez votre MDP et identifiant");
		}

	}

	public void cancelButtonOnAction(ActionEvent event)
	{
		Stage stage = (Stage) annulerButton.getScene().getWindow();
		stage.close();
	}

	public void validationIdent()
	{
//		DatabaseConnection connectNow = new DatabaseConnection();
//		Connection connectDb = connectNow.getConnection();

		Connection connectDb = DatabaseConnection.getInstance().getConnection();

		//String query = "select count(1) from client where nomClient = '" + mdpTextField.getText().trim() + "' and prenom = '" + identifiantTextField.getText().trim() + "' ";
		String query = "{CALL user_identification(?,?)}";

		try
		{

			//Statement statement = connectDb.createStatement();
			CallableStatement stmt = connectDb.prepareCall(query);
			stmt.setString(1, identifiantTextField.getText().trim());
			stmt.setString(2, mdpTextField.getText().trim());

			ResultSet queryResult = stmt.executeQuery();

			while(queryResult.next())
			{
				if (queryResult.getInt("verif")== 1)
				{
					donneeInvalideLabel.setText("congrats");
					creerCompte();
					Utilisateur.getInstance();
					Utilisateur.setConnectedUser(new Utilisateur(queryResult));
				}
				else
				{
					donneeInvalideLabel.setText("Mauvaise identification");
				}
			}
			
						
		} catch(Exception e)
		{
			
			System.out.println("\nvalidationIdent\n");
			e.printStackTrace();
			e.getCause(); 
		}
		System.out.println("\n"+ Utilisateur.getConnectedUser().getLogin() + " est connect?!\n");
		System.out.println("Niveau: "+ Utilisateur.getConnectedUser().getNiveauByIdNiveau().getNomNiveau()+"\n");
		
	}
	
	/**
	 * TEST window dashboard, replacement for Dashboard.fxml ???!!!
	 */
	private void templateWindow() {
		// TODO Auto-generated method stub
		try 
		{
			//MUST RENAME THE VARIABLES!!!!
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("template.fxml"));
			Stage individuStage = new Stage();
			
			individuStage.setScene(new Scene(root));
			individuStage.show();
			cancelButtonOnAction(null);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			e.getCause();
		}
	}

	public void creerCompte () 
	{
		try 
		{
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			Stage individuStage = new Stage();
			
			individuStage.setScene(new Scene(root));
			individuStage.show();
			cancelButtonOnAction(null);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			e.getCause();
		}
	}

public void signIn () 
{
	try 
	{
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("signIn.fxml"));
		Stage signIn = new Stage();
		
		signIn.setScene(new Scene(root));
		signIn.show();
		cancelButtonOnAction(null);
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
		e.getCause();
	}
}
}