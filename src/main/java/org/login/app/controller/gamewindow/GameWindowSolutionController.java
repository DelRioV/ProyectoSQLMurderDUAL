package org.login.app.controller.gamewindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import org.login.app.App;

import java.io.IOException;


/**
 * <p>GameWindowController class.</p>
 *
 * @author Ismael Orellana Bello / Pablo Salvador Del Río Vergara
 * @version 1.0
 * Class that controlls GameWindowSolution.fxml
 */
@Getter
@Setter
public class GameWindowSolutionController {

    private int user_code;
    private String username;

    @FXML
    private TextField solutionField;


    /**
     * Method that goes to CheckSolution.fxml
     *
     * @throws java.io.IOException - in some circunstances
     */
    @FXML
    public void checkSolution() throws IOException{
        FXMLLoader fxmlLoader = App.setRoot("fxml/gamewindow/CheckSolution");
        CheckSolutionController checkSolutionController =fxmlLoader.getController();
        if(solutionField.getText().equals("Julio")){
            checkSolutionController.getSolutionLabel().setText("CONGRATULATIONS YOU WIN!");
        }
        else{
            checkSolutionController.getSolutionLabel().setText("GAME OVER!");
        }
    }



    /**
     * Method that takes back to GameWindow.fxml
     *
     * @throws java.io.IOException - in some circunstances
     */
    @FXML
    public void goBack() throws IOException {
        FXMLLoader fxmlLoader = App.setRoot("fxml/gamewindow/GameWindow");
        GameWindowController gameWindowController = fxmlLoader.getController();
        gameWindowController.setUser_code(user_code);
        gameWindowController.setUser(username);
        gameWindowController.getUsername().setText(username);
    }
}
