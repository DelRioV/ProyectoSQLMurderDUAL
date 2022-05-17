package org.login.app.model.mysql.manager;

import java.sql.Connection;
import java.sql.SQLException;

public interface RegisterManager {

    public boolean compareRegisterQuery(Connection con, String username);

    public void executeRegisterQuery(Connection con,String email, String username,String password) throws SQLException;


}
