package org.login.app.model.mysql.manager.imp;

import javafx.scene.control.Alert;
import org.login.app.model.mysql.manager.QueryRecoverManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public class QueryRecoverManagerImp implements QueryRecoverManager {

    @Override
    public  ArrayList<ArrayList<String>> executeQuery(Connection connection, String query) {
        ArrayList<ArrayList<String>> recoverQuery = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query+";");
            while (rs.next()){
                int index = 1;
                ArrayList<String> addInfo = new ArrayList<>();
                try{
                    while(true) {
                        addInfo.add(rs.getString(index));
                        index++;
                    }
                } catch (Exception e){
                    recoverQuery.add(addInfo);
                }
            }
            return recoverQuery;
        } catch (SQLException e) {
            System.out.println("Something introduced isn't correct");
            return null;
        }
    }

    private void countIndex(ResultSet rs, int index) {

    }
}
