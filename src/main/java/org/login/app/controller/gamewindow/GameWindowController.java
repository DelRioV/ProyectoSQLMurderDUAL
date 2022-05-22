package org.login.app.controller.gamewindow;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import lombok.Getter;
import lombok.Setter;
import org.login.app.App;
import org.login.app.model.mysql.connector.MySQLConnector;
import org.login.app.model.mysql.manager.imp.QueryRecoverManagerImp;
import org.login.app.model.mysql.manager.imp.UserCodeManagerImp;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;


@Getter
@Setter
public class GameWindowController{
    @FXML
    private Label username;

    @FXML
    private Label difficultLevel;

    @FXML
    private TextArea recoverInfoArea;

    @FXML
    private TextArea inputQuery;

    @FXML
    private Label errorLabel;

    private String user;

    //Hay que cambiarlo para que no se pierda el user
    @FXML
    public void goBackLoginMenu() throws IOException {
        System.out.println(user);
        App.setRoot("controller/mainwindow/MainWindow");
    }

    @FXML
    public void executeQuery() throws SQLException,ClassNotFoundException {
        QueryRecoverManagerImp exc = new QueryRecoverManagerImp();
        int user_code =new UserCodeManagerImp().getUserCode(new MySQLConnector().getMySQLConnection(),user);
        try {
            ArrayList<ArrayList<String>> recoverInfo = exc.executeQuery(new MySQLConnector().getMySQLConnection(), inputQuery.getText(),user_code);
            if (recoverInfo != null) {
                recoverInfoArea.setText("");
                for (ArrayList<String> i : recoverInfo) {
                    for (String a : i) {
                        recoverInfoArea.setText(recoverInfoArea.getText() + "   ||   " + a);
                    }
                    recoverInfoArea.setText(recoverInfoArea.getText() + "\n");
                }
                errorLabel.setVisible(false);
            } else {
                errorLabel.setText("You write it wrongly, care your spelling!");
                errorLabel.setVisible(true);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error, you write it wrongly, care your spelling");
            e.printStackTrace();
        }
    }


}