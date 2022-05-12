package org.login.app.loginwindow.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterController {

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passField;

    @FXML
    private PasswordField confirmPassField;

    @FXML
    private void completeRegister() throws IOException, SQLException{

    }

    @FXML
    private void checkPasswords(){

    }

    private boolean checkDataBase() throws SQLException{
        try{
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
