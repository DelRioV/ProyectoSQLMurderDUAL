package org.login.app.service;

import org.login.app.jaxrsclient.client.LoginClient;
import org.login.app.jaxrsclient.dto.User;

public class LoginService {

    public boolean loginToTheApp(User user) {
        try {
            return new LoginClient().getLogin(user).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
