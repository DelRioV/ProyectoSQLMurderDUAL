package org.login.app.jaxrsclient;

import org.login.app.jaxrsclient.client.RegisterClient;
import org.login.app.jaxrsclient.dto.User;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        User user = User.builder().username("pepe").password("pepe").email("pepe@gg").user_code(LocalDateTime.now().getNano()).build();
        System.out.println(user.getUser_code() + "  " + user.getUsername()  + "  " + user.getPassword()  + "  " + user.getEmail());
        System.out.println(new RegisterClient().ping());
        System.out.println(new RegisterClient().postRegister(user));
    }
}
