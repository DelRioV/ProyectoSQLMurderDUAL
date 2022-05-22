package org.login.app.controller.loginwindow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import org.login.app.App;
import org.login.app.controller.mainwindow.MainWindowController;
import org.login.app.model.mysql.connector.MySQLConnector;
import org.login.app.model.mysql.manager.imp.RegisterManagerImp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterSuccesfullyController {

    @FXML
    private TextField confirmRegisterTextField;

    @Getter
    @Setter
    private ArrayList<String> credentials = new ArrayList<>();

    @Setter
    @Getter
    private Integer randomNumber;

    @FXML
    private void registerSuccesfull() throws IOException, SQLException, ClassNotFoundException {
        System.out.println(confirmRegisterTextField.getText().equals(randomNumber.toString()));
        System.out.println(randomNumber);
        if(confirmRegisterTextField.getText().equals(randomNumber.toString())){
            Connection connection = new MySQLConnector().getMySQLConnection();
            insertUser(connection);
            FXMLLoader fxmlLoader = App.setRoot("controller/mainWindow/MainWindow");
            MainWindowController mainWindowController =fxmlLoader.getController();
            mainWindowController.setUser(credentials.get(1));

        }
    }

    public void insertUser(Connection connection) throws SQLException{
        new RegisterManagerImp().executeRegisterQuery(connection, credentials.get(0), credentials.get(1), credentials.get(2));
    }
    
}
