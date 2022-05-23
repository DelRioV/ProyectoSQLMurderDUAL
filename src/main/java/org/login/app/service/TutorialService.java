package org.login.app.service;


import org.login.app.jaxrsclient.client.TutorialClient;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class TutorialService {

    public ArrayList<String> changeTipService() {
        return new TutorialClient().getInfo();
    }
}
