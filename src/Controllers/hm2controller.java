package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class hm2controller implements Initializable {

@FXML
private AnchorPane rootPane;
	
	
	
	
	
	
	@Override

	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}

	@FXML
	private void loadSecont(ActionEvent event) throws IOException {
		
	AnchorPane pane = FXMLLoader.load(getClass().getResource("/Controllers/ABOUT1.fxml"));	
	rootPane.getChildren().setAll(pane);
	}
	
	
}
