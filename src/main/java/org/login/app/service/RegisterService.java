package org.login.app.service;

import org.login.app.model.mysql.connector.MySQLConnector;
import org.login.app.model.mysql.manager.imp.RegisterManagerImp;

import java.sql.Connection;
import java.sql.SQLException;

public class RegisterService {

    public boolean checkDataBase(String username) throws SQLException {
        boolean kk = true;
        try {
            if (new RegisterManagerImp().compareRegisterQuery(new MySQLConnector().getMySQLConnection(), username)) {
                kk = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return kk;
        }

    }
}
