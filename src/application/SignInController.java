package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
		ArrayList<Niveau> niv = new ArrayList<Niveau>();
		
		Connection connectDb = DatabaseConnection.getInstance().getConnection();
		
		String query = "{CALL select_niveau()}";
		
		try 
		{
			
			//Statement statement = connectDb.createStatement();
			CallableStatement stmt = connectDb.prepareCall(query);
			
			ResultSet queryResult = stmt.executeQuery();
					
			while(queryResult.next()) 
			{
				Niveau temp = null;
				temp.setIdNiveau(stmt.getInt("Id_Niveau"));
				temp.setNomNiveau(stmt.getString("Nom_Niveau"));
				niv.add(temp);
			}
				
		} 
		catch(Exception e)
		{
			
			System.out.println("\nProblem PopulateCombobox\n");
			e.printStackTrace();
			e.getCause(); 
		}
		niveau.getItems().addAll(niv);
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
			stmt.setInt(5, niveau.getValue().getIdNiveau());
			
			stmt.execute(); 
				
		} 
		catch(Exception e)
		{
			
			System.out.println("\ninsert_utilisateur NAN\n");
			e.printStackTrace();
			e.getCause(); 
		}
	}
	
}
