package br.com.maurigvs.fileexchange;

import br.com.maurigvs.fileexchange.tutorial.TutorialController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FileExchangeApiApplicationTests {

    @Autowired
    TutorialController tutorialController;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(tutorialController);
    }

}
