package br.com.maurigvs.fileexchange.csv;

import java.io.ByteArrayInputStream;
import java.util.List;

import br.com.maurigvs.fileexchange.tutorial.Tutorial;
import br.com.maurigvs.fileexchange.tutorial.TutorialService;
import org.springframework.stereotype.Service;

@Service
public class CSVService {

    private final TutorialService tutorialService;

    public CSVService(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    public ByteArrayInputStream load() {
        List<Tutorial> tutorials = tutorialService.listAllTutorials();
        ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
        return in;
    }
}
