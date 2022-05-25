package org.login.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @Author: Ismael Orellana Bello / Pablo Salvador Del Río Vergara
 * @Version: 1.0
 * Class that launches the program(first JavaFx)
 * JavaFX org.login.app.App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    /**
     * Methos that create the stage and set the scene
     *
     * @param stage - Stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        scene = new Scene(loadFXML("fxml/loginwindow/LoginWindow").load());
        stage.setScene(scene);
        stage.setTitle("Inicio");
        stage.show();
    }

    /**
     * Method that change the scene
     *
     * @param fxml - String (file which is going to be search)
     * @return FXMLLoader
     * @throws IOException
     */
    public static FXMLLoader setRoot(String fxml) throws IOException {
        FXMLLoader fxmlLoader = loadFXML(fxml);
        stage.hide();
        scene.setRoot(fxmlLoader.load());
        stage.show();
        return fxmlLoader;
    }

    /**
     * Method that give back the .fxml file
     *
     * @param fxml - String (file which is going to be search)
     * @return FXMLLoader
     * @throws IOException
     */
    private static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    /**
     * Method which launch the JavaFx
     *
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

}
