package application;
	
import java.sql.SQLException;

import ctrlEntites.CtrlDocument;

import java.util.List;

import entites.Utilisateur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("LoginView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
		/*
		 * System.out.println("en cours de developement"); DataAccess database =new
		 * DataAccess(); List<Utilisateur> list =database.getAll();
		 * 
		 * List<Utilisateur> list1 =database.getUtilistaeurByKeyWord(2);
		 */
	}
}
