package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import java.awt.Desktop;

public class InterfaceCreationController implements Initializable {
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private Button annulerButton;
	@FXML
	private Button bnt_browser;
	@FXML
	private TextArea textarea;
	@FXML
	private Label labelTest;
	FileChooser file = new FileChooser();

	public void switchDashboard() {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			Stage individuStage = new Stage();

			individuStage.setScene(new Scene(root, 778, 605));
			individuStage.show();
			Stage stage = (Stage) annulerButton.getScene().getWindow();
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}

	@FXML
	public void browser() {
		try {
			file.setTitle("Ouvrir un document");
			file.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"),new ExtensionFilter("PDF", "*.pdf"));
			File selectedFile = file.showOpenDialog(null);
			if (selectedFile != null) {
				 Desktop desktop = Desktop.getDesktop();
				desktop.open(selectedFile);
				/*Scanner scanner = new Scanner(selectedFile);
				while (scanner.hasNextLine()) {
					textarea.appendText(scanner.nextLine());*/
				//}

			}

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}

	public void save(MouseEvent event) {

		File file1 = file.showSaveDialog(new Stage());
		if (file1 != null) {
			saveSystem(file1, textarea.getText());

		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		file.setInitialDirectory(
				new File("C:\\Users\\Meriem\\Dropbox\\Mon PC (DESKTOP-29Q3FOJ)\\Desktop\\Nouveau dossier"));

	}

	public void saveSystem(File file, String content) {
		try {
			PrintWriter printWriter = new PrintWriter(file);
			printWriter.write(content);
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
