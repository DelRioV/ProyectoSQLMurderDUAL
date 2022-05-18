package org.login.app.controller.loginwindow;

import java.util.Random;

public class ReturnRandomClass {

    public ReturnRandomClass(){

    }

    public int generateRandomNumber(){
        return new Random().nextInt((1000 - 100) + 100);
    }

}
