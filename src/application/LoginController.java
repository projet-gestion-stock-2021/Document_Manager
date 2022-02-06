package application;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import application.SignInController;
import application2.AbstractDAO;

public class LoginController  extends AbstractDAO
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
			
			Alert alert=new Alert(AlertType.WARNING,"Entrez votre MDP et identifiant",ButtonType.OK);
	    	alert.showAndWait();
		}

	}

	public void cancelButtonOnAction(ActionEvent event)
	{
		Stage stage = (Stage) annulerButton.getScene().getWindow();
		stage.close();
	}

	public void validationIdent()
	{
//		
		String query = "{CALL user_identification(?,?)}";

		try
		{

			
			CallableStatement stmt = connection.prepareCall(query);
			stmt.setString(1, identifiantTextField.getText().trim());
			stmt.setString(2, mdpTextField.getText().trim());

			ResultSet queryResult = stmt.executeQuery();

			while(queryResult.next())
			{
				if (queryResult.getInt(1)== 1)
				{
					Alert alert=new Alert(AlertType.CONFIRMATION,"vous êtes connectés",ButtonType.OK);
	    	    	alert.showAndWait();
					//donneeInvalideLabel.setText("congrats");
					creerCompte();
				}
				else
				{

					
					Alert alert=new Alert(AlertType.ERROR,"Mauvaise identification",ButtonType.OK);
					
					
					alert.showAndWait();
					
					

					Alert alert1=new Alert(AlertType.ERROR,"Identidiant et/ou mot de passe incorrect",ButtonType.OK);
	    	    	alert1.showAndWait();

				}
			}
				
		} catch(Exception e)
		{
			
			System.out.println("fuck\n");
			e.printStackTrace();
			e.getCause(); 
		}
		
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