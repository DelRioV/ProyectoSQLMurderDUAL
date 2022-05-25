package org.login.app.controller.tutorialwindow;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.login.app.App;
import org.login.app.service.TutorialService;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.awt.Desktop;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @Author: Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @Version: 1.0
 * Class that controlls TutorialWindow.fxml
 */

public class TutorialController implements Initializable {


    @FXML
    private Button tutorialButton_1;

    @FXML
    private Button sqlTutorial;

    @FXML
    private Button alreadyNow;

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @FXML
    private Label editableLabel;
    private int infoCounter = -1;
    private int counter = 1;
    private ArrayList<String> infoRecover;

    /**
     * Method that switch the window, depends on the counter inside this class
     *
     * @param event - the one who has activate the Event
     * @throws IOException
     */
    @FXML
    public void switchWindow(Event event) throws IOException {
        if (event.getSource() == alreadyNow) {
            counter++;
        }
        App.setRoot("fxml/tutorialwindow/TutorialWindow" + counter);

    }

    /**
     * Method that leads you to a website in case you don't know nothing about SQL
     */
    @FXML
    public void getSqlTutorialLink() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.w3schools.com/sql/default.asp"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method that depends on the counter set one or other text to the window
     *
     * @param event - the one who has activate the Event
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @FXML
    public void changeLabelText(Event event) throws SQLException, ClassNotFoundException {
        try {
            if (event.getSource() == previousButton && infoCounter > 0) {
                editableLabel.setText(infoRecover.get(--infoCounter));
            } else if (event.getSource() == nextButton && infoCounter < 5) {
                editableLabel.setText(infoRecover.get(++infoCounter));
            }
        } catch (Exception e) {

        }
    }

    /**
     * Method that initialize
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.infoRecover = new TutorialService().changeTipService();
    }
}
