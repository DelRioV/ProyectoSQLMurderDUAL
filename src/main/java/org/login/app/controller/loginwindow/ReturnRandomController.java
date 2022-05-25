package org.login.app.controller.loginwindow;

import java.util.Random;

/**
 * <p>ReturnRandomController class.</p>
 *
 * @author : Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version : 1.0
 * Class that returns a random number for confirm code
 */
public class ReturnRandomController {

    /**
     * <p>Constructor for ReturnRandomController.</p>
     */
    public ReturnRandomController() {

    }

    /**
     * Generate a random number
     *
     * @return randomNumber - int
     */
    public int generateRandomNumber() {
        return new Random().nextInt((1000 - 100) + 100);
    }

}
