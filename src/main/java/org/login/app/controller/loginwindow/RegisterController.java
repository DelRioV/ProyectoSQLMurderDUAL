package org.login.app.controller.loginwindow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import org.login.app.App;
import org.login.app.email.Sender;

import org.login.app.jaxrsclient.client.LoginClient;
import org.login.app.jaxrsclient.dto.User;
import org.login.app.pdfcreator.PdfCreator;
import org.login.app.service.RegisterService;

import java.io.IOException;
import java.util.ArrayList;

/**
 * <p>RegisterController class.</p>
 *
 * @author : Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version : 1.0
 * Class that controlls RegisterWindow.fxml
 */
@Getter
@Setter
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
    private TextField confirmRegisterTextField;

    @FXML
    private PasswordField passField;

    @FXML
    private PasswordField confirmPassField;

    private final static Integer RANDOMNUMBER = new ReturnRandomController().generateRandomNumber();

    private ArrayList<String> credentials = new ArrayList<>();

    /**
     * Method that gets register credentials, check them and finally add them into the Data Base if all is done correctly
     */
    @FXML
    private void registerClient() {
        try {
            if (!usernameField.getText().isEmpty() && !emailField.getText().isEmpty() && !passField.getText().isEmpty()
                    && !confirmPassField.getText().isEmpty()) {
                if (checkPasswords()) {
                    User user = User.builder().username(usernameField.getText()).password(passField.getText()).email(emailField.getText()).build();
                    if (new RegisterService().registerService(user)) {
                        FXMLLoader fxmlLoader = App.setRoot("fxml/loginwindow/CompletingRegister");
                        RegisterSuccesfullyController registerSuccesfullyController = fxmlLoader.getController();
                        registerSuccesfullyController.getCredentials().add(emailField.getText());
                        registerSuccesfullyController.getCredentials().add(usernameField.getText());
                        registerSuccesfullyController.getCredentials().add(passField.getText());
                        registerSuccesfullyController.setRandomNumber(RANDOMNUMBER);
                        sentEmail(emailField.getText());
                        new PdfCreator().createPDF("UserInformation", "Your user_code is: " + new LoginClient().getLogin(user) + "\nYour username is: " + usernameField.getText() + "\nYour password is: " + passField.getText(), usernameField.getText(), passField.getText());

                    } else {
                        System.out.println("Nombre de usuario ya existente");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that checks if both password fields(passField and confirmPassField)
     *
     * @return <ol>
     * <li>boolean true - when both fields have the same text</li>
     * <li>boolean false - when both fields have different texts</li>
     * </ol>
     */
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

    /**
     * Method that calls the one which sends the email to a remitent
     *
     * @param to - String (is the target of the email)
     */
    public void sentEmail(String to) {

        try {
            new Sender().send("sqlmurderproyect@gmail.com", to, "Check your account", "Your code is : " + RANDOMNUMBER);
        } catch (Exception e) {
            System.out.println("Correo no encontrado");
        }

    }

    /**
     * Method that leads back to LoginWindow.fxml when clicking on a button
     *
     * @throws IOException
     */
    @FXML
    private void goBack() throws IOException {
        App.setRoot("fxml/loginwindow/LoginWindow");
    }


}
