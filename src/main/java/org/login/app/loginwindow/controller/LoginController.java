package org.login.app.loginwindow.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.login.app.App;
import org.login.app.mysql.MySQLConnector;
import org.login.app.mysql.manager.imp.LoginSuccesfulManagerImp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private void loginToTheApp() throws SQLException,ClassNotFoundException{
            Connection connection = new MySQLConnector().getMySQLConnection();
            boolean condition = new LoginSuccesfulManagerImp().executeLoginQuery(connection,userTextField.getText(),passwordField.getText());
            if(condition){
                System.out.println("Succesfully");
            }
            else{
                errorMessage.setText("username or password are incorrect");
            }
        }

    @FXML
    private void notRegister() throws IOException{
        App.setRoot("org.login.app.loginwindow/RegisterWindow");
    }

    private void checkUser() throws SQLException{

    }

}
