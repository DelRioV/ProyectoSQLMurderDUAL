package org.login.app.jaxrsclient.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.login.app.jaxrsclient.dto.User;

public class LoginClient {
    private final WebTarget webTarget;

    /**
     * Constructor that create the WebTarget
     */
    public LoginClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/webService/api/");
    }

    /**
     * @param user - User
     * @return <ol>
     * <ol>
     *     <li>boolean true - when is correctly execute </li>
     *     <li>boolean false - when can´t be executed due to an error</li>
     * </ol>
     */
    public Boolean getLogin(User user) {
        return webTarget.path("login/get/" + user.getUsername() + "/" + user.getPassword())
                .request(MediaType.APPLICATION_JSON)
                .get(Boolean.class);
    }
}
