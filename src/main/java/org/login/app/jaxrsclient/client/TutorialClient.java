package org.login.app.jaxrsclient.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

public class TutorialClient {

    private final WebTarget webTarget;

    public TutorialClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/webService/api/");
    }

    public ArrayList<String> getInfo() {

        return webTarget.path("tutorial/get")
                .request(MediaType.APPLICATION_JSON)
                .get(ArrayList.class);
    }
}
