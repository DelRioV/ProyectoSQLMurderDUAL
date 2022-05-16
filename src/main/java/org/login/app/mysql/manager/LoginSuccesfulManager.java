package org.login.app.mysql.manager;

import java.sql.Connection;

public interface LoginSuccesfulManager {

    public boolean executeLoginQuery(Connection con,String username,String password);

}
