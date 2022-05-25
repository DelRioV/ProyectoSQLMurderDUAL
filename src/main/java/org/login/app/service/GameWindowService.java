package org.login.app.service;


import org.login.app.jaxrsclient.client.GameWindowClient;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Author: Pablo Salvador Del Rio Vergara / Ismael Orellana Bello
 * @Version: 1.0
 * Class which is use as a connection between controller and client
 */
public class GameWindowService {
    /**
     * Method that connects with the client
     *
     * @param usercode - int
     * @param query    - String
     * @return ArrayList<ArrayList < String>> - (results of the query)
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<ArrayList<String>> executeQuery(int usercode, String query) throws SQLException, ClassNotFoundException {
        return new GameWindowClient().getLogin(query, usercode);
    }

    /**
     * Method that connects with the client
     *
     * @param username - String
     * @return user_code - int
     */
    public int getUsercode(String username) {
        return new GameWindowClient().getUsercode(username);
    }
}
