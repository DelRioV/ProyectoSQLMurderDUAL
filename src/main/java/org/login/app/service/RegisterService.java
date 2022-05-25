package org.login.app.service;

import org.login.app.jaxrsclient.client.RegisterClient;
import org.login.app.jaxrsclient.dto.User;

/**
 * @Author: Pablo Salvador Del Rio Vergara / Ismael Orellana Bello
 * @Version: 1.0
 * Class which is use as a connection between controller and client
 */

public class RegisterService {
    /**
     * Method that connects with the client
     *
     * @param user - User
     * @return<ol> <li>boolean true - when user is correctly registered</li>
     * <li>boolean false - when user isn't correctly registered</li>
     * </ol>
     */
    public boolean registerService(User user) {
        try {
            return new RegisterClient().postRegister(user).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
