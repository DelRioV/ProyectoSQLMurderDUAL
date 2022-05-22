package org.login.app.controller.mainwindow;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lombok.Getter;
import lombok.Setter;
import org.login.app.App;
import org.login.app.controller.gamewindow.GameWindowController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController{

    @Getter
    @Setter
    private String user;

    @FXML
    private Button playButton;

    @FXML
    private Button startTutorialButton;

    @FXML
    private void switchWindow(Event event) throws IOException{
        String text="";
        if(event.getSource()==playButton){
            System.out.println("hola amigo");
            text="fxml/gamewindow/GameWindow";
        }
        else if(event.getSource()==startTutorialButton){
            System.out.println("adios");
            text="fxml/tutorialwindow/originTutorialWindow";
        }
        else{
            text="";//En proceso
        }
        changeWindow(text);
    }





    private void changeWindow(String text) throws IOException {
        if(text.equals("fxml/gamewindow/GameWindow")){
            FXMLLoader fxmlLoader = App.setRoot(text);
            GameWindowController gameWindowController = fxmlLoader.getController();
            gameWindowController.getUsername().setText(user);
            gameWindowController.getUsername().setVisible(true);
        }
        App.setRoot(text);
    }


}
