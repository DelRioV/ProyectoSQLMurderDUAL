package org.login.app.jaxrsclient.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.login.app.jaxrsclient.dto.User;

public class LoginClient {
    private final WebTarget webTarget;

    public LoginClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/webService/api/");
    }

    public Boolean getLogin(User user) {
        return webTarget.path("login/get/"+user.getUsername()+"/"+user.getPassword())
                .request(MediaType.APPLICATION_JSON)
                .get(Boolean.class);
    }
}
