package org.login.app.mysql.manager;

import java.sql.Connection;
import java.sql.SQLException;

public interface ModelInfoManager {

    public String changeTip(Connection con,int id) throws SQLException;

}
