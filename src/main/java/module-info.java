module org.login.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires static lombok;
    requires jakarta.ws.rs;
    requires jakarta.xml.bind;
    requires jakarta.activation;
    requires jakarta.mail;
    requires itextpdf;


    exports org.login.app;
    exports org.login.app.jaxrsclient.dto;

    opens org.login.app.controller.loginwindow to javafx.fxml;
    opens org.login.app.controller.gamewindow to javafx.fxml;
    opens org.login.app.controller.tutorialwindow to javafx.fxml;
    opens org.login.app.controller.mainwindow to javafx.fxml;

    opens org.login.app.fxml.gamewindow to javafx.fxml;
    opens org.login.app.fxml.loginwindow to javafx.fxml;
    opens org.login.app.fxml.mainwindow to javafx.fxml;
    opens org.login.app.fxml.tutorialwindow to javafx.fxml;

}