package org.login.app.model.mysql.manager;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserCodeManager {

    public int getUserCode(Connection con, String username) throws SQLException;
}
