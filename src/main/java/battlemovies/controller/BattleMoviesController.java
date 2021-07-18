package battlemovies.controller;

import battlemovies.modelo.Filmes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/quizz")
@RestController
public class BattleMoviesController {

    @GetMapping//teste de exibição
    public String mensagem(){
        return "Bem vindo ao Battle Movies!";
    }

//    @GetMapping
//    public List<Filmes> exibirFilmes(){
//        //Aqui será a exibição dos 2 filmes para a batalha
//        return null;
//    }
//
//    @PostMapping
//    public boolean checkResultado(){
//        //Aqui será a checagem se o usuário acertou ou não
//         //O calculo ele ira pegar os votosIMBD e multiplicar pelo rattingIMDB, gerando uma votaReal de ambos os filmes
//        //Caso tenha acertado ou errado, é feito um contato de até 3 tentativas
//        //Quanto mais o jogador joga novamente, e mais ele acerta, mais ele sobe no ranking, essa é uma ideia de classificação
//        return false;
//    }

}
