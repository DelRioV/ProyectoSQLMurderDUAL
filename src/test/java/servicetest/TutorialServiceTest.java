package servicetest;

import org.junit.jupiter.api.Test;
import org.login.app.service.TutorialService;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TutorialServiceTest {

    @Test
    void changeTipService_ok() {
        TutorialService tutorialService = new TutorialService();
        ArrayList<String> result = tutorialService.changeTipService();
    }

}