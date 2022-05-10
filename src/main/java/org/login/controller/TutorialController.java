package org.login.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import mysql.MySQLConnector;
import mysql.manager.imp.ModelInfoManagerImp;
import org.login.App;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.Desktop;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class TutorialController implements Initializable {

    private Connection con ;

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

    private int counter=1;

    @FXML
    public void switchWindow(Event event) throws IOException {
        if(event.getSource()==alreadyNow){
            counter++;
        }
        App.setRoot("tutorialWindow"+counter);

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

    @FXML
    public void changeLabelText(Event event) throws SQLException, ClassNotFoundException {
        Connection con = new MySQLConnector().getMySQLConnection();

        if(event.getSource()==previousButton){
           editableLabel.setText(new ModelInfoManagerImp().changeTip(con,1));
        }
        else if(event.getSource()==nextButton){
            editableLabel.setText(new ModelInfoManagerImp().changeTip(con,1));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
