module org.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    exports org.login;
    opens org.login to javafx.fxml;
    exports org.login.controller;
    opens org.login.controller to javafx.fxml;
}