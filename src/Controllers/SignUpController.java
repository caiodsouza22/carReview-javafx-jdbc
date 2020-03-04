package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.*;

import DB.ModuloConexao;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SignUpController implements Initializable {

	@FXML
	private AnchorPane parentPane;

	@FXML
	private JFXButton login;

	@FXML
	private JFXTextField name;

	@FXML
	private JFXButton signup;

	@FXML
	private JFXRadioButton male;

	@FXML
	private ToggleGroup genders;

	@FXML
	private JFXRadioButton female;

	@FXML
	private JFXRadioButton other;

	@FXML
	private JFXTextField location;

	@FXML
	private ImageView progress;

	@FXML
	private JFXPasswordField password;

	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public SignUpController() {
	
		conexao = (Connection) ModuloConexao.conector();

	}
	
	@FXML
	public void signupAction(ActionEvent e) {
		String sql = "INSERT INTO tbusers(user,password,gender,location)" 
				+ "VALUES (?,?,?,?)";
		
		try {
			pst = (PreparedStatement) conexao.prepareStatement(sql);
			pst.setString(1, name.getText());
			pst.setString(2, password.getText());
			pst.setString(3, getGender());
			pst.setString(4, location.getText());
			
			pst.executeUpdate();
			

			PauseTransition pt = new PauseTransition();
			pt.setDuration(Duration.seconds(3));
			pt.setOnFinished(ev -> {

			});
			pt.play();
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		

	}

	@FXML
	public void loginAction(ActionEvent e) throws IOException {
		signup.getScene().getWindow().hide();

		progress.setVisible(false);

		Stage login = new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/LoginMain.fxml"));
		Scene scene = new Scene(root);
		login.setScene(scene);
		login.show();
		login.setResizable(false);

	}
	
	public String getGender() {
		String gen = "";
		
		if(male.isSelected())
		{
			gen = "Male";
		}
		else if(female.isSelected()) 
		{
			gen = "Female";
		}
		else if(other.isSelected())
		{
			gen = "Other";
		}
			return gen;
	}
	
   @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	name.setStyle("-fx-text-inner-color: #a0a2ab;");
	password.setStyle("-fx-text-inner-color: #a0a2ab;");
	location.setStyle("-fx-text-inner-color: #a0a2ab;");
	
	}
}
