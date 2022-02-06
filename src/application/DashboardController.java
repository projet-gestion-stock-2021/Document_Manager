package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DashboardController {
	
	@FXML
	private Button creationDocumentButton, rechercheDocumentButton, exitDashboard, affichageUtiButton;
	
	public void switchInterfaceCreation () 
	{
		try 
		{
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("InterfaceCreation.fxml"));
			Stage individuStage = new Stage();
			
			individuStage.setScene(new Scene(root));
			individuStage.show();
			Stage stage = (Stage) creationDocumentButton.getScene().getWindow();
			stage.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			e.getCause();
		}
	}
	
	public void switchInterfaceRecherche () 
	{
		try 
		{
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("ScanDoc.fxml"));
			Stage individuStage = new Stage();
			
			individuStage.setScene(new Scene(root));
			individuStage.show();
			Stage stage = (Stage) rechercheDocumentButton.getScene().getWindow();
			stage.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			e.getCause();
		}
	}
	public void cancelButtonOnAction(ActionEvent event) {
		Stage stage = (Stage) exitDashboard.getScene().getWindow();
		stage.close(); }
	
	public void switchInterfaceUti () 
	{
		try 
		{
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AffichageUtilisateurs.fxml"));
			Stage individuStage = new Stage();
			
			individuStage.setScene(new Scene(root));
			individuStage.show();
			Stage stage = (Stage) affichageUtiButton.getScene().getWindow();
			stage.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			e.getCause();
		}
	}
}


