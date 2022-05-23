package org.login.app.model.mysql.manager.imp;

import org.login.app.model.mysql.manager.ModelInfoManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelInfoManagerImp implements ModelInfoManager {


    @Override
    public ArrayList<String> changeTip(Connection con) throws SQLException {
        try {
            PreparedStatement psmt = con.prepareStatement("Select tutorialInfo from model ");
            ResultSet resultSet = psmt.executeQuery();
            ArrayList<String> infoString = new ArrayList<>();
            while(resultSet.next()) {
                 infoString.add(resultSet.getString(1));
            }
            return infoString;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
