package org.login.app.service;

import org.login.app.jaxrsclient.client.LoginClient;
import org.login.app.jaxrsclient.client.RegisterClient;
import org.login.app.jaxrsclient.dto.User;


import java.sql.Connection;
import java.sql.SQLException;

public class RegisterService {

  public boolean registerService(User user){
      try {
          return new RegisterClient().postRegister(user).booleanValue();
      } catch (Exception e) {
          e.printStackTrace();
          return false;
      }
  }
}
