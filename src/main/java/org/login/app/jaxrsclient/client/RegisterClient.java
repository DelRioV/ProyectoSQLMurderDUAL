package org.login.app.jaxrsclient.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.login.app.jaxrsclient.dto.User;

public class RegisterClient {

    private final WebTarget webTarget;

    public RegisterClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/webService/api/");
    }

    public User postRegister(User user) {
        return webTarget.path("register/post")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(user,MediaType.APPLICATION_JSON), User.class);
    }
}
