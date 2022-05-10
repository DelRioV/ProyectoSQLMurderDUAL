package org.login.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.login.App;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.Desktop;
import java.util.ResourceBundle;


public class TutorialController implements Initializable {

    @FXML
    private Button tutorialButton_1;

    @FXML
    private Button sqlTutorial;

    private int counter = 1;

    @FXML
    public void switchWindow() throws IOException {
        App.setRoot("tutorialWindow"+counter++);
    }

    @FXML
    public void getSqlTutorialLink(){
        try {
            Desktop.getDesktop().browse(new URI("https://www.w3schools.com/sql/default.asp"));
        } catch (URISyntaxException ex) {

            System.out.println(ex);

        }catch(IOException e){

            System.out.println(e);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
