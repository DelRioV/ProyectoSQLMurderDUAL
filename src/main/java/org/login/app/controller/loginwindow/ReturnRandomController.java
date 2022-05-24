package org.login.app.controller.loginwindow;

import java.util.Random;

public class ReturnRandomController {

    public ReturnRandomController(){

    }

    public int generateRandomNumber(){
        return new Random().nextInt((1000 - 100) + 100);
    }

}
