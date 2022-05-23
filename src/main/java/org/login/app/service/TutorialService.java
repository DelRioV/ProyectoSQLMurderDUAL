package org.login.app.service;

import org.login.app.model.mysql.connector.MySQLConnector;
import org.login.app.model.mysql.manager.imp.ModelInfoManagerImp;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class TutorialService {

    public ArrayList<String> changeTipService() {
        try {
            return new ModelInfoManagerImp().changeTip(new MySQLConnector().getMySQLConnection());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
