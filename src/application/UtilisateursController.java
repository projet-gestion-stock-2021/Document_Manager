package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.SQLException;

import ctrlEntites.CtrlUser;
import entity.Utilisateur;
import entity.Niveau;

public class UtilisateursController  
{

    @FXML
    private TableView<Utilisateur> tableUti;
    
    @FXML
    private TableColumn <Utilisateur, Integer> Id;

    @FXML
    private TableColumn <Utilisateur, String> Nom;
    
    @FXML
    private TableColumn <Utilisateur, String> Prenom;
    
    @FXML
    private TableColumn <Utilisateur, String> Login;
    
    @FXML
    private TableColumn <Niveau, String> Niveau;
    
    
    
    @FXML
    private Button refreshButton;
    
    @FXML
    private Button exitButton;
    
    public void switchDashboard () 
	{
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			Stage individuStage = new Stage();
			individuStage.setScene(new Scene(root));
			individuStage.show();
			Stage stage = (Stage) exitButton.getScene().getWindow();
			stage.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			e.getCause();
		}
	}
    
    public void FillTableList ()
    {
    	CtrlUser listUser = new CtrlUser();   
    	try {
			listUser.charger();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Nom.setCellValueFactory( new PropertyValueFactory<Utilisateur, String>("Nom"));
    	Prenom.setCellValueFactory( new PropertyValueFactory<Utilisateur, String>("Prenom"));
    	//Niveau.setCellValueFactory( new PropertyValueFactory<Niveau, String>("Niveau"));
    	tableUti.setItems(listUser.getListeAfficheUti()); 
    }
    
    public void ActionRefreshButton(ActionEvent event)
    {
    	FillTableList();
    }
}
