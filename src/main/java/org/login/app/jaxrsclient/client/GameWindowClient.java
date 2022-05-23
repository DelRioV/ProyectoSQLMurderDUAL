package org.login.app.jaxrsclient.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.login.app.controller.gamewindow.GameWindowController;
import org.login.app.jaxrsclient.dto.User;

import java.util.ArrayList;

public class GameWindowClient {

    private final WebTarget webTarget;

    public GameWindowClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/webService/api/");
    }

    public ArrayList<ArrayList<String>> getLogin(String query, int user_code) {
        return webTarget.path("game/get/" + query + "/" + user_code)
                .request(MediaType.APPLICATION_JSON)
                .get(ArrayList.class);
    }

    public int getUsercode(String username) {
        return webTarget.path("game/getusercode/" + username).request(MediaType.APPLICATION_JSON).get(int.class);
    }
}
