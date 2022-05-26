package org.login.app.controller.tutorialwindow;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.Getter;
import lombok.Setter;
import org.login.app.App;
import org.login.app.controller.mainwindow.MainWindowController;
import org.login.app.service.TutorialService;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.awt.Desktop;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * <p>TutorialController class.</p>
 *
 * @author : Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version : 1.0
 * Class that controlls TutorialWindow.fxml
 */

@Getter
@Setter
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
    private String username;
    private ArrayList<String> infoRecover;

    /**
     * Method that switch the window, depends on the counter inside this class
     *
     * @param event - the one who has activate the Event
     * @throws java.io.IOException - in some circunstancies
     */
    @FXML
    public void switchWindow(Event event) throws IOException {
        FXMLLoader fxmlLoader = App.setRoot("fxml/tutorialwindow/TutorialWindow2");
        TutorialController tutorialController = fxmlLoader.getController();
        tutorialController.setUsername(username);
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
     * @throws java.sql.SQLException - in some circunstancies
     * @throws java.lang.ClassNotFoundException - in some circunstancies
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
    @FXML
    public void changeToGameWindow() throws IOException {
        FXMLLoader fxmlLoader = App.setRoot("fxml/mainwindow/MainWindow");
        MainWindowController mainWindowController = fxmlLoader.getController();
        mainWindowController.setUser(username);
    }

    /**
     * {@inheritDoc}
     *
     * Method that initialize
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.infoRecover = new TutorialService().changeTipService();
    }
}
