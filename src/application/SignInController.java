package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

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
	private ComboBox<Niveau> niveau;
	
	
}
