package org.login.app.jaxrsclient.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

public class TutorialClient {

    private final WebTarget webTarget;

    /**
     * Constructor that create the WebTarget
     */
    public TutorialClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/webService/api/");
    }

    /**
     * Method that connects with webservice
     *
     * @return ArrayList<String> - information about model
     */
    public ArrayList<String> getInfo() {

        return webTarget.path("tutorial/get")
                .request(MediaType.APPLICATION_JSON)
                .get(ArrayList.class);
    }
}
