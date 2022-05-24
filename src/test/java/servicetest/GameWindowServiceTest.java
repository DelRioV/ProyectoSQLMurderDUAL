package servicetest;

import org.junit.jupiter.api.Test;
import org.login.app.service.GameWindowService;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameWindowServiceTest {

    @Test
    void executeQuery_ok() throws SQLException, ClassNotFoundException {
        GameWindowService gameWindowService = new GameWindowService();
        ArrayList<ArrayList<String>> result = gameWindowService.executeQuery(1,"Select * from Rooms");
        assertEquals(result, new ArrayList<ArrayList<String>>());
    }

    @Test
    void executeQuery_ko() throws SQLException, ClassNotFoundException {
        GameWindowService gameWindowService = new GameWindowService();
        ArrayList<ArrayList<String>> result = gameWindowService.executeQuery(1,"Select * from user");
        assertEquals(result, null);
    }
}