package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;




import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class LoginController  {

	@FXML
	private Button annulerButton;
	@FXML
	private Label donneeInvalideLabel;
	@FXML
	private TextField identifiantTextField;
	@FXML
	private PasswordField mdpTextField;

	
	
	public void identifiantButtonOnAction (ActionEvent event) {
		
		
		if(identifiantTextField.getText().isBlank() == false && mdpTextField.getText().isBlank() == false)  {
			validationIdent();
		} else {
			donneeInvalideLabel.setText("Entrez votre MDP et identifiant");
		}
		
	}
	
	public void cancelButtonOnAction(ActionEvent event) {
		Stage stage = (Stage) annulerButton.getScene().getWindow();
		stage.close(); 
	}
	public void validationIdent() {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDb = connectNow.getConnection();
		
		String verifId= "select count(1) from client where nomClient = '" + mdpTextField.getText().trim() + "' and prenom = '" + identifiantTextField.getText().trim() + "' ";
		
		
		try {
			
			Statement statement = connectDb.createStatement();
			ResultSet queryResult = statement.executeQuery(verifId);
					
			while(queryResult.next()) {
				if (queryResult.getInt(1)== 1) {
					donneeInvalideLabel.setText("congrats");
				}
				else {
					donneeInvalideLabel.setText("Mauvaise identification");
				}
			}
				
		} catch(Exception e){
			
			System.out.println("fuck");
		e.printStackTrace();
			e.getCause(); 
		}
	}
}
