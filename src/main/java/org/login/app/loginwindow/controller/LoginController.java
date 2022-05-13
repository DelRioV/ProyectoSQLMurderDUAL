package org.login.app.loginwindow.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.login.app.App;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void loginToTheApp() throws SQLException{

    }

    @FXML
    private void notRegister() throws IOException{
        App.setRoot("RegisterWindow");
    }

    private void checkUser() throws SQLException{

    }

}
