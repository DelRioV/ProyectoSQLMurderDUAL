package servicetest;

import org.junit.jupiter.api.Test;
import org.login.app.jaxrsclient.dto.User;
import org.login.app.service.RegisterService;

import static org.junit.jupiter.api.Assertions.*;

class RegisterServiceTest {

    @Test
    void registerService_ok() {
        RegisterService registerService = new RegisterService();
        boolean result = registerService.registerService(User.builder().username("pablo").password("pablo").email("pabloskydelriovergara@gmail.com").build());
        assertEquals(result,true);
    }

    @Test
    void registerService_ko() {
        RegisterService registerService = new RegisterService();
        boolean result = registerService.registerService(User.builder().username("admin").password("1234").email("admin@gmail.com").build());
        assertEquals(result,false);
    }
}