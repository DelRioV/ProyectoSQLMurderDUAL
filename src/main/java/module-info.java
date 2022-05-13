module org.login.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires static lombok;


    exports org.login.app;
    opens org.login.app to javafx.fxml;
    opens org.login.app.loginwindow.controller to javafx.fxml;

}