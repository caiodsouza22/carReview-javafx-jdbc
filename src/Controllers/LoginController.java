package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;


public class LoginController implements Initializable {
 
	@FXML
    private JFXButton signup;

    @FXML
    private JFXTextField username;
    
    @FXML
    private JFXCheckBox remember;
   
    @FXML
    private JFXButton login;
   
    @FXML 
    private JFXButton forgotpassword;
    
    @FXML
    private ImageView progress; 
    
    @FXML
    private JFXPasswordField password;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		progress.setVisible(false);
		username.setStyle("-fx-text-inner-color: #a0a2ab;");
		password.setStyle("-fx-text-inner-color: #a0a2ab;");
		
	}
	

	
	@FXML
	public void loginAction(ActionEvent e) {
		progress.setVisible(true);
		PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(ev -> {
			System.out.println("Login successfully");
		});
	
		pt.play();
	}

	@FXML
	public void signUp(ActionEvent e1) throws IOException {
		login.getScene().getWindow().hide();
		Stage signup = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/Controllers/SignupMain.fxml"));
		Scene scene = new Scene(root);
		signup.setScene(scene);
		signup.show();
		signup.setResizable(false);
		
	}
	
   
}
  

