package org.login.app.jaxrsclient.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

/**
 * <p>GameWindowClient class.</p>
 *
 * @author : Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version : 1.0
 * Class that connects to the web service ("api/game")
 */
public class GameWindowClient {

    private final WebTarget webTarget;

    /**
     * Constructor that create the WebTarget
     */
    public GameWindowClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/webService/api/");
    }

    /**
     * Method that connect with a .get webservice
     *
     * @param query     - String (the query that wants to be executed)
     * @param user_code - int (the user_code who is using the program
     * @return ArrayList (The information that results from the execution of the query)
     */
    public ArrayList<ArrayList<String>> getLogin(String query, int user_code) {
        return webTarget.path("game/get/" + query + "/" + user_code)
                .request(MediaType.APPLICATION_JSON)
                .get(ArrayList.class);
    }

    /**
     * Method that connect with .get webservice
     *
     * @param username - String
     * @return user_code - int
     */
    public int getUsercode(String username) {
        return webTarget.path("game/getusercode/" + username).request(MediaType.APPLICATION_JSON).get(int.class);
    }
}
