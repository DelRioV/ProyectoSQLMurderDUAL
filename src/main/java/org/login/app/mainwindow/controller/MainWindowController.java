package org.login.app.mainwindow.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.login.app.loginwindow.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private Button playButton;

    @FXML
    private Button startTutorialButton;

    @FXML
    private void switchWindow(Event event) throws IOException{
        String text="";
        if(event.getSource()=="Play"){
            text="GameWindow";
        }
        else if(event.getSource()=="Start Tutorial"){
            text="originTutorialWindow";
        }
        else{
            text="";//En proceso
        }
        changeWindow(text);
    }





    private void changeWindow(String text) throws IOException {
        App.setRoot(text);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
