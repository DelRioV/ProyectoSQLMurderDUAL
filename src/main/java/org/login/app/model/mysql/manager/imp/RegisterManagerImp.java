package org.login.app.model.mysql.manager.imp;

import org.login.app.model.mysql.manager.RegisterManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class RegisterManagerImp implements RegisterManager {
    @Override
    public boolean compareRegisterQuery(Connection con, String username) {
        try {
            boolean condicion = false;
            PreparedStatement preparedStatement = con.prepareStatement("SELECT username from user " +
                    "where username = ? ");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                condicion = true;
            }
            return condicion;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void executeRegisterQuery(Connection con, String email, String username, String password) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO user VALUES (?,?,?,?)");
        preparedStatement.setInt(1, LocalDateTime.now().getNano());
        preparedStatement.setString(2, username);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        System.out.println("soy sql");
        preparedStatement.executeUpdate();
    }


}
