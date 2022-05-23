package org.login.app.service;



import org.login.app.jaxrsclient.client.GameWindowClient;

import java.sql.SQLException;
import java.util.ArrayList;

public class GameWindowService {

    public ArrayList<ArrayList<String>> executeQuery(int usercode, String query) throws SQLException, ClassNotFoundException {
        return new GameWindowClient().getLogin(query,usercode);
    }
    public int getUsercode(String username){
        return new GameWindowClient().getUsercode(username);
    }
}
