package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import DB.ModuloConexao;
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

	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

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

	public LoginController() {
		conexao = (Connection) ModuloConexao.conector();
		if (conexao != null) {
			System.out.println("Conectado");

		} else {
			System.out.println("Nao conectado");
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		progress.setVisible(false);
		username.setStyle("-fx-text-inner-color: #a0a2ab;");
		password.setStyle("-fx-text-inner-color: #a0a2ab;");

	}

	@FXML
	public void loginAction(ActionEvent e) {
		String sql = "select * from tbusers where user=? and password=?";
		try {
			pst = (PreparedStatement) conexao.prepareStatement(sql);
			pst.setString(1, username.getText());
			pst.setString(2, password.getText());
			
			rs = pst.executeQuery();

			if(rs.next()) {
				login.getScene().getWindow().hide();
				Stage login = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/Controllers/HomePage2.fxml"));
				Scene scene = new Scene(root);
				login.setScene(scene);
				login.show();
				login.setResizable(false);

			
			 }else {
				 System.out.println("usuário / ou senha inválidos");
			 }
		 }catch (Exception e1) {
			 
		 }
			
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
