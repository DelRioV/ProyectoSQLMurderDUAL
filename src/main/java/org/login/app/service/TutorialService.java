package org.login.app.service;


import org.login.app.jaxrsclient.client.TutorialClient;


import java.util.ArrayList;

/**
 * <p>TutorialService class.</p>
 *
 * @author  Pablo Salvador Del Rio Vergara / Ismael Orellana Bello
 * @version  1.0
 * Class which is use as a connection between controller and client
 */
public class TutorialService {
    /**
     * Method that connects with the client
     *
     * @return ArrayList - (recovers information about tips)
     */
    public ArrayList<String> changeTipService() {
        return new TutorialClient().getInfo();
    }
}
