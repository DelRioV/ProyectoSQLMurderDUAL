package org.login.app.controller.gamewindow;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import lombok.Getter;
import lombok.Setter;
import org.login.app.App;
import org.login.app.service.GameWindowService;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @Version: 1.0
 * Class that controlls GameWindow.fxml
 */
@Getter
@Setter
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
    private Label errorLabel;
    private String user;
    private int user_code;
    private String text;

    /**
     * Method that takes back to MainWindow.fxml
     * @throws IOException - in case there is an error when loading the window
     */
    @FXML
    public void goBackLoginMenu() throws IOException {
        App.setRoot("fxml/mainwindow/MainWindow");
    }

    /**
     * Method that execute the query that was written in GameWindow.fxml
     * @return <ol>
     *     <li>boolean true - when is correctly execute </li>
     *     <li>boolean false - when can´t be executed due to an error</li>
     * </ol>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @FXML
    public boolean executeQuery() throws SQLException, ClassNotFoundException {

        ArrayList<ArrayList<String>> recoverInfo = new GameWindowService().executeQuery(new GameWindowService().getUsercode(username.getText()), inputQuery.getText());
        if (recoverInfo != null) {
            recoverInfoArea.setText("");
            recoverInfo.stream().collect(Collectors.toList()).forEach(strings -> {
                recoverInfoArea.setText(recoverInfoArea.getText() + Arrays.asList(strings) + "\n");
            });
            errorLabel.setVisible(false);
            return true;
        } else {
            errorLabel.setText("You write it wrongly, care your spelling!");
            errorLabel.setVisible(true);
            return false;
        }
    }
}




