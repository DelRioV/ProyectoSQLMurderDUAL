package org.login.app.controller.loginwindow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.login.app.App;
import org.login.app.model.mysql.connector.MySQLConnector;
import org.login.app.model.mysql.manager.imp.LoginSuccesfulManagerImp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorMessage;

    @FXML
    private void loginToTheApp() throws SQLException, ClassNotFoundException, IOException {
            Connection connection = new MySQLConnector().getMySQLConnection();
            boolean condition = new LoginSuccesfulManagerImp().executeLoginQuery(connection,userTextField.getText(),passwordField.getText());
            if(condition){
                System.out.println("Succesfully");
                App.setRoot("controller/org.login.app.gamewindow/GameWindow");

            }
            else{
                errorMessage.setVisible(true);
            }
        }

    @FXML
    private void notRegister() throws IOException{
        App.setRoot("controller/org.login.app.loginwindow/RegisterWindow");
    }

    private void checkUser() throws SQLException{

    }

}
