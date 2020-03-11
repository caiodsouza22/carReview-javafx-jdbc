package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class FerrariController implements Initializable {

	@FXML
	private JFXButton back;
	
	@FXML
	private JFXButton back2;
	
	AnchorPane CarInfo;
	
	@FXML
	private JFXButton ferrari458;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}
	
	@FXML
	public void backAction(ActionEvent evt) {
		
		
		HomePageController.getInstance().createPage(CarInfo, "/Controllers/Home.fxml");
	}

	@FXML
	public void back2Action(ActionEvent evt) {
		
		
		HomePageController.getInstance().createPage(CarInfo, "/Controllers/HomeFerrari.fxml");
	}
	
	
	@FXML
	public void ferrari458Action(ActionEvent e) {
		
		HomePageController.getInstance().createPage(CarInfo, "/Controllers/Ferrari1.fxml");
	}
	
}
