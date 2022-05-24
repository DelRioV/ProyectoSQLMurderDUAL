package servicetest;

import org.junit.jupiter.api.Test;
import org.login.app.jaxrsclient.dto.User;
import org.login.app.service.LoginService;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    @Test
    void loginToTheApp_ok() {
        LoginService loginService = new LoginService();
        boolean result = loginService.loginToTheApp(User.builder().username("admin").password("1234").build());
        assertEquals(result,true);
    }

    @Test
    void loginToTheApp_ko() {
        LoginService loginService = new LoginService();
        boolean result = loginService.loginToTheApp(User.builder().username("adin").password("1234").build());
        assertEquals(result,false);
    }
}