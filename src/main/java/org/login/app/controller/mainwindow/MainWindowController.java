package org.login.app.controller.mainwindow;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import lombok.Getter;
import lombok.Setter;
import org.login.app.App;
import org.login.app.controller.gamewindow.GameWindowController;
import org.login.app.controller.tutorialwindow.TutorialController;

import java.io.IOException;

/**
 * <p>MainWindowController class.</p>
 *
 * @author : Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version : 1.0
 * Class that controlls MainWindow.fxml
 */
public class MainWindowController {

    @Getter
    @Setter
    private String user;

    @FXML
    private Button playButton;

    @FXML
    private Button startTutorialButton;

    /**
     * Method that leads to one or other window depends on what button you have clicked
     *
     * @param event - the one who has activate the Event
     * @throws IOException
     */
    @FXML
    private void switchWindow(Event event) throws IOException {
        String text = "";
        if (event.getSource() == playButton) {
            text = "fxml/gamewindow/GameWindow";
        } else if (event.getSource() == startTutorialButton) {
            text = "fxml/tutorialwindow/originTutorialWindow";
        } else {
            text = "";
        }
        changeWindow(text);
    }

    /**
     * Method that change the window depends on what button was clicked
     *
     * @param text - String - is the URL where .fxml is located
     * @throws IOException
     */
    private void changeWindow(String text) throws IOException {
        if (text.equals("fxml/gamewindow/GameWindow")) {
            FXMLLoader fxmlLoader = App.setRoot(text);
            GameWindowController gameWindowController = fxmlLoader.getController();
            gameWindowController.setUser(user);
            gameWindowController.getUsername().setText(user);
            gameWindowController.getUsername().setVisible(true);
        } else if(text.equals("fxml/tutorialwindow/originTutorialWindow")){
           FXMLLoader fxmlLoader =  App.setRoot(text);
           TutorialController tutorialController = fxmlLoader.getController();
           tutorialController.setUser_code(user);
        }
    }


}
