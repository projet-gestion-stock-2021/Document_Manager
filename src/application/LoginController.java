package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;




import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class LoginController  {

	@FXML
	private Button annulerButton;
	@FXML
	private Label donneeInvalideLabel;
	@FXML
	private TextField identifiantTextField;
	@FXML
	private PasswordField mdpTextField;

	
	
	public void identifiantButtonOnAction (ActionEvent event) 
	{
		
		
		if(identifiantTextField.getText().isBlank() == false && mdpTextField.getText().isBlank() == false)  
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
				if (queryResult.getInt(1)== 1) 
				{
					donneeInvalideLabel.setText("congrats");
					creerCompte();
				}
				else 
				{
					donneeInvalideLabel.setText("Mauvaise identification");
				}
			}
				
		} catch(Exception e)
		{
			
			System.out.println("fuck\n");
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
			
			individuStage.setScene(new Scene(root,778,605));
			individuStage.show();
			cancelButtonOnAction(null);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			e.getCause();
		}
	}
}
