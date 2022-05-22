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


    exports org.login.app;
    exports org.login.app.jaxrsclient.dto;
    opens org.login.app to javafx.fxml;
    opens org.login.app.controller.gamewindow to javafx.fxml;
    opens org.login.app.controller.loginwindow to javafx.fxml;
    opens org.login.app.controller.mainwindow to javafx.fxml;
    opens org.login.app.controller.tutorialwindow to javafx.fxml;

}