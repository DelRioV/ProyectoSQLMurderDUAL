package org.login.app.service;

import org.login.app.jaxrsclient.client.RegisterClient;
import org.login.app.jaxrsclient.dto.User;

public class LoginService {

    public boolean loginToTheApp(User user) {
        try {
            return new RegisterClient().postRegister(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
