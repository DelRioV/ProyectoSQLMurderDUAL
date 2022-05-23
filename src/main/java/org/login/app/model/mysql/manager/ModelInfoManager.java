package org.login.app.model.mysql.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ModelInfoManager {

    public ArrayList<String> changeTip(Connection con) throws SQLException;

}
