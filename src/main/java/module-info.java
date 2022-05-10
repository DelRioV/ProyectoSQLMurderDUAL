module org.login.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires static lombok;

    exports org.login.app.tutorialwindow;
    exports org.login.app.tutorialwindow.controller;
    opens org.login.app.tutorialwindow.controller to javafx.fxml;
    opens org.login.app.tutorialwindow to javafx.fxml;
}