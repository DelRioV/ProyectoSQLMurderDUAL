package org.login.app.controller.loginwindow;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.login.app.App;
import org.login.app.email.Sender;
import org.login.app.model.mysql.connector.MySQLConnector;
import org.login.app.model.mysql.manager.imp.RegisterManagerImp;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class RegisterController{

    @FXML
    private Button registerButton;
    @FXML
    private Button backButton;
    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField confirmRegisterTextField;

    @FXML
    private PasswordField passField;

    @FXML
    private PasswordField confirmPassField;

    @FXML
    private Label errorLabel;

    private final static Integer RANDOMNUMBER = new ReturnRandomClass().generateRandomNumber();

    private ArrayList<String> credentials = new ArrayList<>();

    @FXML
    private void completeRegister() throws IOException, SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        if(!usernameField.getText().isEmpty() && !emailField.getText().isEmpty() && !passField.getText().isEmpty()
            && !confirmPassField.getText().isEmpty()) {
            if (checkPasswords()) {
                if (checkDataBase(connection)) {
                    credentials.add(emailField.getText());
                    credentials.add(usernameField.getText());
                    credentials.add(passField.getText());
                    System.out.println(credentials.get(0));
                    sentEmail(emailField.getText());
                    System.out.println(RANDOMNUMBER);
                    App.setRoot("controller/loginwindow/CompletingRegister");
                } else {
                    errorLabel.setText("Username exists");
                    errorLabel.setVisible(true);
                }
            }
        } else {
            errorLabel.setText("Fields can't be empty");
            errorLabel.setVisible(true);
        }
    }

    @FXML
    private boolean checkPasswords() {
        boolean kk = false;
        if (passField.getText().equals(confirmPassField.getText())) {
            kk = true;
        } else {
            System.out.println("Contraseña distinta");
        }
        return kk;
    }

    public void insertUser(Connection connection) throws SQLException{
        new RegisterManagerImp().executeRegisterQuery(connection, credentials.get(0), credentials.get(1), credentials.get(2));
    }

    private boolean checkDataBase(Connection connection) throws SQLException {
        boolean kk = true;
        try {
            if (new RegisterManagerImp().compareRegisterQuery(connection, usernameField.getText())) {
                kk = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return kk;
        }

    }

    public void sentEmail(String to){

        try{
            new Sender().send("sqlmurderproyect@gmail.com",to,"Check your account","Your code is : "+RANDOMNUMBER);
        }catch (Exception e){
            System.out.println("Correo no encontrado");
        }

    }



    @FXML
    private void goBack() throws IOException {
        System.out.println(App.class.getResource(""));
        App.setRoot("controller/loginwindow/LoginWindow");
    }

    @FXML
    private void registerSuccesfull() throws IOException, SQLException, ClassNotFoundException {
        System.out.println(confirmRegisterTextField.getText().equals(RANDOMNUMBER.toString()));
        System.out.println(RANDOMNUMBER);
        if(confirmRegisterTextField.getText().equals(RANDOMNUMBER.toString())){
            Connection connection = new MySQLConnector().getMySQLConnection();
            insertUser(connection);
            System.out.println("LLego");
            System.out.println(App.class.getResource(""));
            App.setRoot("controller/gameWindow/GameWindow.fxml");
        }
    }


}
