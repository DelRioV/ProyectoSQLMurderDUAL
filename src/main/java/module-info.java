module org.login.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires static lombok;
    requires java.mail;
    requires activation;
    requires jakarta.ws.rs;


    exports org.login.app;
    opens org.login.app to javafx.fxml;
    opens org.login.app.controller.gamewindow to javafx.fxml;
    opens org.login.app.controller.loginwindow to javafx.fxml;
    opens org.login.app.controller.mainwindow to javafx.fxml;
    opens org.login.app.controller.tutorialwindow to javafx.fxml;

}