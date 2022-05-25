package org.login.app.controller.loginwindow;

import java.util.Random;

/**
 * @Author: Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @Version: 1.0
 * Class that returns a random number for confirm code
 */
public class ReturnRandomController {

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
