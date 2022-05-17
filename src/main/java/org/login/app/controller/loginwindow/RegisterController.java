package org.login.app.controller.loginwindow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.login.app.App;
import org.login.app.model.mysql.connector.MySQLConnector;
import org.login.app.model.mysql.manager.imp.RegisterManagerImp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class RegisterController {

    @FXML
    private Button registerButton;
    @FXML
    private Button backButton;
    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passField;

    @FXML
    private PasswordField confirmPassField;

    @FXML
    private void completeRegister() throws IOException, SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        if (checkPasswords()) {
            if (checkDataBase(connection)) {
                new RegisterManagerImp().executeRegisterQuery(connection, emailField.getText(), usernameField.getText(), passField.getText());
                System.out.println("Usuario creado");
                goBack();
            } else {
                System.out.println("Nombre de usuario ya existente");
            }
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

    @FXML
    private void goBack() throws IOException {
        System.out.println(App.class.getResource(""));
        App.setRoot("org.login.app.loginwindow/LoginWindow");
    }
}
