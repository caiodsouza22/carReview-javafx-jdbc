package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXToolbar;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HomePageController implements Initializable {

	@FXML
	private AnchorPane rootPane;

	AnchorPane home;

	@FXML
	private Text welcome;
	
	@FXML
	private JFXToolbar toolbar;
	
	@FXML
	private HBox toolBarRight;
	
	@FXML
	private VBox overFlowContaner;
	
	@FXML
	private JFXButton btnLogOut;
	
	@FXML
	private JFXButton btnExit;
	
	@FXML
	private Label lblMenu;
	
	@FXML
	private AnchorPane anchor;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	
		
		createPage();

	}


   
		
       
	   

	private void setNode(Node node) {
		rootPane.getChildren().clear();
		rootPane.getChildren().add((Node) node);

		FadeTransition ft = new FadeTransition(Duration.millis(1500));
		ft.setNode(node);
		ft.setFromValue(0.1);
		ft.setToValue(1);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		ft.play();

	}

	private void createPage() {

		try {
			home = FXMLLoader.load(getClass().getResource("/Controllers/Home.fxml"));
			setNode(home);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	private void loadSecont(ActionEvent event) throws IOException {

		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Controllers/Home.fxml"));
		rootPane.getChildren().setAll(pane);
	}

	
	@FXML
	private void quitAction(ActionEvent evt) {
		Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to quit? ", ButtonType.YES, ButtonType.NO);
		alert.showAndWait();

		if (alert.getResult() == ButtonType.YES) {
			System.exit(0);
		}

	}
	
	@FXML
	private void logoutAction(ActionEvent evt2) {
		
		btnLogOut.getScene().getWindow().hide();
		
		Stage login = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/Controllers/LoginMain.fxml/"));
			
			Scene scene  = new Scene(root);
			login.setScene(scene);
			login.show();
			login.setResizable(false);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
}