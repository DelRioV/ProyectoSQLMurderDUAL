package org.login.app.service;

import org.login.app.model.mysql.connector.MySQLConnector;
import org.login.app.model.mysql.manager.imp.QueryRecoverManagerImp;
import org.login.app.model.mysql.manager.imp.UserCodeManagerImp;

import java.sql.SQLException;
import java.util.ArrayList;

public class GameWindowService {

    public ArrayList<ArrayList<String>> executeQuery(String user, String query) throws SQLException, ClassNotFoundException {
        QueryRecoverManagerImp exc = new QueryRecoverManagerImp();
        int user_code = new UserCodeManagerImp().getUserCode(new MySQLConnector().getMySQLConnection(), user);
        try {
            return exc.executeQuery(new MySQLConnector().getMySQLConnection(), query, user_code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
