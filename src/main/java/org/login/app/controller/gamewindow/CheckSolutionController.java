package org.login.app.controller.gamewindow;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lombok.Getter;
import lombok.Setter;
import org.login.app.App;
import java.io.IOException;


/**
 * <p>GameWindowController class.</p>
 *
 * @author Ismael Orellana Bello / Pablo Salvador Del Río Vergara
 * @version 1.0
 * Class that controlls CheckSolution.fxml
 */
@Getter
@Setter
public class CheckSolutionController {

    @FXML
    private Label solutionLabel;


    /**
     * Method that restart the game
     *
     * @throws java.io.IOException - in some circunstances
     */
    @FXML
    public void restartApp() throws IOException {
        App.setRoot("fxml/loginwindow/LoginWindow");
    }

}
