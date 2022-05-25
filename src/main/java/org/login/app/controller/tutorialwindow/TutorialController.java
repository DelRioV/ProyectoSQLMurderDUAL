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

    @FXML
    public void switchWindow(Event event) throws IOException {
        if (event.getSource() == alreadyNow) {
            counter++;
        }
        App.setRoot("fxml/tutorialwindow/TutorialWindow" + counter);

    }

    @FXML
    public void getSqlTutorialLink() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.w3schools.com/sql/default.asp"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.infoRecover = new TutorialService().changeTipService();
    }
}
