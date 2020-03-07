package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomeController implements Initializable {

	@FXML
	private AnchorPane homeAnchor;
	
	@FXML
	private JFXButton tesla;
	
	@FXML
	private JFXButton ferrari;

	@FXML
	private JFXButton lamborghini;

	@FXML
	private JFXButton porsche;

	
	private AnchorPane CarsAnchor;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	
	@FXML
	public void teslaAction(ActionEvent e) {
		
		HomePageController.getInstance().createPage(CarsAnchor, "/Controllers/HomeTesla.fxml");
	}
	



	@FXML
	public void ferrariAction(ActionEvent e) {
		
	}
	
	@FXML
	public void lamborghiniAction(ActionEvent e) {
		
	}
	
	@FXML
	public void porscheAction(ActionEvent e) {
		
	}
}
