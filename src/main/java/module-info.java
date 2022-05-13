module org.login.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires static lombok;


    opens org.login.app.loginwindow.controller to javafx.fxml;
    opens org.login.app.loginwindow to javafx.fxml;
    exports org.login.app.loginwindow;
}