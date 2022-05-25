package org.login.app.controller.loginwindow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import org.login.app.App;
import org.login.app.controller.mainwindow.MainWindowController;
import org.login.app.jaxrsclient.client.RegisterClient;
import org.login.app.jaxrsclient.dto.User;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * <p>RegisterSuccesfullyController class.</p>
 *
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Class that controlls CompletingRegister.fxml
 */
public class RegisterSuccesfullyController {

    @FXML
    private TextField confirmRegisterTextField;

    @Getter
    @Setter
    private ArrayList<String> credentials = new ArrayList<>();

    @Setter
    @Getter
    private Integer randomNumber;

    /**
     * Method that confirms that the inserted code and the confirm code are the same
     *
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @FXML
    private void registerSuccesfull() throws IOException, SQLException, ClassNotFoundException {
        if (confirmRegisterTextField.getText().equals(randomNumber.toString())) {
            insertUser();
            FXMLLoader fxmlLoader = App.setRoot("fxml/mainWindow/MainWindow");
            MainWindowController mainWindowController = fxmlLoader.getController();
            mainWindowController.setUser(credentials.get(1));
        }
    }

    /**
     * Method that calls postRegister()
     *
     * @throws java.sql.SQLException - in some circunstancies
     */
    public void insertUser() throws SQLException {
        new RegisterClient().postRegister(User.builder().username(credentials.get(1)).password(credentials.get(2)).email(credentials.get(0)).user_code(LocalDateTime.now().getNano()).build());
    }

}
