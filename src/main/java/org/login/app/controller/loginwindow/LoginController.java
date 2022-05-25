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

/**
 * @Author: Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @Version: 1.0
 * Class that controlls LoginWindow.fxml
 */
public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorMessage;

    /**
     * Method that confirms login credentials and let access to MainWindow.fxml
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
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

    /**
     * Method that leads you to RegisterWindow.fxml when clicking on a button
     *
     * @throws IOException
     */
    @FXML
    private void notRegister() throws IOException {
        App.setRoot("fxml/loginwindow/RegisterWindow");
    }

}
