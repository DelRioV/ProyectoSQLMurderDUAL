package org.login.app.mysql.manager.imp;

import org.login.app.mysql.manager.ModelInfoManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelInfoManagerImp implements ModelInfoManager {


    @Override
    public String changeTip(Connection con, int id) throws SQLException {
        try {
            PreparedStatement psmt = con.prepareStatement("Select tutorialInfo from model where modelId = ?");
            psmt.setInt(id,1);
            ResultSet resultSet = psmt.executeQuery();
            resultSet.next();
                return resultSet.getString(1);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
