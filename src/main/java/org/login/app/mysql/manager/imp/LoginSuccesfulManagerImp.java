package org.login.app.mysql.manager.imp;

import org.login.app.mysql.MySQLConnector;
import org.login.app.mysql.manager.LoginSuccesfulManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginSuccesfulManagerImp implements LoginSuccesfulManager {
    @Override
    public boolean executeLoginQuery(Connection con, String username, String password) {
        try{
            boolean condicion=false;
            PreparedStatement preparedStatement = con.prepareStatement("SELECT username,pwd_user from user " +
                    "where username = ? and pwd_user = ?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                condicion=true;
            }
            return condicion;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
