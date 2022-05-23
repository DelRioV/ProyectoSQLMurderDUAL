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

import org.login.app.service.RegisterService;

import java.io.IOException;
import java.util.ArrayList;

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

    private final static Integer RANDOMNUMBER = new ReturnRandomClass().generateRandomNumber();

    private ArrayList<String> credentials = new ArrayList<>();

    @FXML
    private void registerClient() {
        try {
            if (!usernameField.getText().isEmpty() && !emailField.getText().isEmpty() && !passField.getText().isEmpty()
                    && !confirmPassField.getText().isEmpty()) {
                if (checkPasswords()) {
                    if (new RegisterService().checkDataBase(usernameField.getText())) {
                       // new RegisterClient().postRegister(User.builder().username(usernameField.getText()).password(passField.getText()).email(emailField.getText()).user_code(LocalDateTime.now().getNano()).build());
                        FXMLLoader fxmlLoader = App.setRoot("fxml/loginwindow/CompletingRegister");
                        RegisterSuccesfullyController registerSuccesfullyController = fxmlLoader.getController();
                        registerSuccesfullyController.getCredentials().add(emailField.getText());
                        registerSuccesfullyController.getCredentials().add(usernameField.getText());
                        registerSuccesfullyController.getCredentials().add(passField.getText());
                        registerSuccesfullyController.setRandomNumber(RANDOMNUMBER);
                        sentEmail(emailField.getText());

                    } else {
                        System.out.println("Nombre de usuario ya existente");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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



    public void sentEmail(String to) {

        try {
            new Sender().send("sqlmurderproyect@gmail.com", to, "Check your account", "Your code is : " + RANDOMNUMBER);
        } catch (Exception e) {
            System.out.println("Correo no encontrado");
        }

    }


    @FXML
    private void goBack() throws IOException {
        System.out.println(App.class.getResource(""));
        App.setRoot("fxml/loginwindow/LoginWindow");
    }


}
