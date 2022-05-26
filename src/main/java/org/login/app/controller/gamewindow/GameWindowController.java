package org.login.app.controller.gamewindow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import lombok.Getter;
import lombok.Setter;
import org.login.app.App;
import org.login.app.controller.mainwindow.MainWindowController;
import org.login.app.service.GameWindowService;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>GameWindowController class.</p>
 *
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
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
     *
     * @throws java.io.IOException - in some circunstances
     */
    @FXML
    public void goBackLoginMenu() throws IOException {
        FXMLLoader fxmlLoader = App.setRoot("fxml/mainwindow/MainWindow");
        MainWindowController mainWindowController = fxmlLoader.getController();
        mainWindowController.setUser(String.valueOf(user));
    }

    /**
     * Method that execute the query that was written in GameWindow.fxml
     *
     * @return <ol>
     *     <li>boolean true - when is correctly execute </li>
     *     <li>boolean false - when can´t be executed due to an error</li>
     * </ol>
     * @throws java.sql.SQLException - in some circunstacies
     * @throws java.lang.ClassNotFoundException - in some circunstacies
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

    @FXML
    public void goSolutionWindow() throws IOException{
        FXMLLoader fxmlLoader = App.setRoot("fxml/gamewindow/GameWindowSolution");
        GameWindowSolutionController gameWindowSolutionController = fxmlLoader.getController();
        gameWindowSolutionController.setUser_code(user_code);
        gameWindowSolutionController.setUsername(username.getText());
    }
}




