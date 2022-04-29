package org.login.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.login.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TutorialController implements Initializable {

    @FXML
    private Button tutorialButton_1;

    private int counter=0;

    @FXML
    public void switchWindow() throws IOException {
        System.out.println("llego");
        //App.setRoot("tutorialWindow"+counter++);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
