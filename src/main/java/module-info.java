module org {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    exports org.login;
    opens org.login to javafx.fxml;
    exports org.login.controller;
    opens org.login.controller to javafx.fxml;
}