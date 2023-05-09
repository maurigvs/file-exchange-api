package br.com.maurigvs.fileexchange.tutorial;

import br.com.maurigvs.fileexchange.csv.CSVService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin("http://localhost:8081")
@Controller
@RequestMapping("/tutorials")
public class TutorialController {

    private final TutorialService tutorialService;
    private final CSVService fileService;

    public TutorialController(TutorialService tutorialService, CSVService fileService) {
        this.tutorialService = tutorialService;
        this.fileService = fileService;
    }

    @PostMapping("/input")
    public ResponseEntity<Void> postTutorial(@RequestBody Tutorial tutorial){
        tutorialService.createTutorial(tutorial);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> getFile() {
        String filename = "tutorials.csv";
        InputStreamResource file = new InputStreamResource(fileService.load());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }
}
