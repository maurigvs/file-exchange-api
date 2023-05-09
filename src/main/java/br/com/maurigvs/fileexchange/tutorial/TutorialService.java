package br.com.maurigvs.fileexchange.tutorial;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TutorialService {

    private final TutorialRepository repository;

    public TutorialService(TutorialRepository repository) {
        this.repository = repository;
    }

    public Tutorial createTutorial(Tutorial tutorial){
        return repository.save(tutorial);
    }

    public List<Tutorial> listAllTutorials(){
        return repository.findAll();
    }
}
