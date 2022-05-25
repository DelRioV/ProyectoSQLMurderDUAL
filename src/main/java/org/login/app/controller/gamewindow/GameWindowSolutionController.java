package org.login.app.controller.gamewindow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import org.login.app.App;

import java.io.IOException;

@Getter
@Setter
public class GameWindowSolutionController {

    private int user_code;
    private String username;

    @FXML
    private TextField solutionField;

    @FXML
    public void checkSolution(){
        if(solutionField.getText().equals("Julio")){

        }
        else{

        }
    }

    @FXML
    public void goBack() throws IOException {
        FXMLLoader fxmlLoader = App.setRoot("fxml/gamewindow/GameWindow");
        GameWindowController gameWindowController = fxmlLoader.getController();
        gameWindowController.setUser_code(user_code);
        gameWindowController.setUser(username);
        gameWindowController.getUsername().setText(username);
    }
}
