package org.login.app.controller.gamewindow;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.login.app.App;
import org.login.app.model.mysql.connector.MySQLConnector;
import org.login.app.model.mysql.manager.imp.QueryRecoverManagerImp;

import java.io.IOException;
import java.util.ArrayList;

public class GameWindowController {
    @FXML
    private Label username;

    @FXML
    private Label difficultLevel;

    @FXML
    private TextArea recoverInfoArea;

    @FXML
    private TextArea inputQuery;


    @FXML
    public void goBackLoginMenu() throws IOException {
        App.setRoot("controller/org.login.app.loginwindow/LoginWindow");
    }

    @FXML
    public void executeQuery() {
        QueryRecoverManagerImp exc = new QueryRecoverManagerImp();
        try {
            ArrayList<ArrayList<String>> recoverInfo = exc.executeQuery(new MySQLConnector().getMySQLConnection(), inputQuery.getText());
//            if (recoverInfo != null) {
//                for (ArrayList<String> i : recoverInfo) {
//                    for (String a : i) {
//                        System.out.println(a);
//                    }
//                    System.out.println("---------------");
//               }
//           }
            recoverInfoArea.setText("");
            for (ArrayList<String> i : recoverInfo) {
                for (String a : i) {
                    recoverInfoArea.setText(recoverInfoArea.getText()+"   ||   " + a);
                }
                recoverInfoArea.setText(recoverInfoArea.getText() + "\n");
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error, you write it wrongly, care your spelling");
            e.printStackTrace();
        }
    }
}