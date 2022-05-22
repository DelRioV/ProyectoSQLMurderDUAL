package org.login.app.model.mysql.manager.imp;

import org.login.app.model.mysql.connector.MySQLConnector;
import org.login.app.model.mysql.manager.UserCodeManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCodeManagerImp implements UserCodeManager {



    @Override
    public int getUserCode(Connection con, String username) throws SQLException{
        int number=0;
        PreparedStatement psm = con.prepareStatement("Select cod_user from user where username = ?");
        psm.setString(1,username);
        ResultSet rs = psm.executeQuery();
        if (rs.next()){
            number=rs.getInt(1);
        }
        return number;
    }
}
