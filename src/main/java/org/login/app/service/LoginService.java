package org.login.app.service;

import org.login.app.model.mysql.connector.MySQLConnector;
import org.login.app.model.mysql.manager.imp.LoginSuccesfulManagerImp;

import java.sql.Connection;

public class LoginService {

    public boolean loginToTheApp(String username, String password) {
        try {
            return new LoginSuccesfulManagerImp().executeLoginQuery(new MySQLConnector().getMySQLConnection(), username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
