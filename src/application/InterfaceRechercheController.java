package application;

import java.net.URL;
import java.util.ResourceBundle;

import entity.Document;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InterfaceRechercheController implements Initializable
{

	@FXML
	private Button annulerButton, switchSceneButton;
	@FXML
	private TableView<Document> documentTable;
	@FXML
	private TextField searchField;
	@FXML
	private TextField labelSearch1, labelSearch2;
	
	public void switchDashboard () {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			Stage individuStage = new Stage();
			individuStage.setScene(new Scene(root));
			individuStage.show();
			Stage stage = (Stage) annulerButton.getScene().getWindow();
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
	
	public void switchSceneOnAction () {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("InterfaceCreation.fxml"));
			Stage individuStage = new Stage();
			individuStage.setScene(new Scene(root));
			individuStage.show();
			Stage stage = (Stage) switchSceneButton.getScene().getWindow();
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub
		
	}
}
