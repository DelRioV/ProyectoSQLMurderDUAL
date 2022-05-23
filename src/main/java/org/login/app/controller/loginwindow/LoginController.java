package org.login.app.controller.loginwindow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.login.app.App;
import org.login.app.controller.mainwindow.MainWindowController;
import org.login.app.jaxrsclient.dto.User;
import org.login.app.service.LoginService;

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
    private Label errorMessage;

    @FXML
    private void loginToTheApp() throws SQLException, ClassNotFoundException, IOException {
        if (new LoginService().loginToTheApp(User.builder().username(userTextField.getText()).password(passwordField.getText()).build())) {
            System.out.println("Succesfully");
            FXMLLoader fxmlLoader = App.setRoot("fxml/mainwindow/MainWindow");
            MainWindowController mainWindowController = fxmlLoader.getController();
            mainWindowController.setUser(userTextField.getText());

        } else {
            errorMessage.setVisible(true);
        }
    }

    @FXML
    private void notRegister() throws IOException {
        App.setRoot("fxml/loginwindow/RegisterWindow");
    }

    private void checkUser() throws SQLException {

    }

}
