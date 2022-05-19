package org.login.app.jaxrsclient;
import org.login.app.jaxrsclient.client.RegisterClient;
import org.login.app.jaxrsclient.dto.User;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println(new RegisterClient().postRegister(
                User.builder().username("pepe").password("pepe").email("pepe@gg").user_code(LocalDateTime.now().getNano()).build()));
    }
}
