package battlemovies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/quizz")
@RestController
public class BattleMoviesController {

    @GetMapping
    public String mensagem(){
        return "Bem vindo ao Battle Movies!";
    }

}
