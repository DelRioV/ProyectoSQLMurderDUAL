package org.login.app.service;

import org.login.app.jaxrsclient.client.LoginClient;
import org.login.app.jaxrsclient.dto.User;

/**
 * <p>LoginService class.</p>
 *
 * @author  Pablo Salvador Del Rio Vergara / Ismael Orellana Bello
 * @version  1.0
 * Class which is use as a connection between controller and client
 */
public class LoginService {
    /**
     * Method that connects with the client
     *
     * @param user - User
     * @return <ol>
     * <li>boolean true - when user is correctly logged</li>
     * <li>boolean false - when user isn't correctly logged</li>
     * </ol>
     */
    public boolean loginToTheApp(User user) {
        try {
            return new LoginClient().getLogin(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
