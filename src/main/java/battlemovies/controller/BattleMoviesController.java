package battlemovies.controller;

import battlemovies.dao.FilmesDaoImpl;
import battlemovies.dao.RankingDaoImpl;
import battlemovies.modelo.Filmes;
import battlemovies.servicos.JogosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/quizz")
@RestController
public class BattleMoviesController {

    @Autowired
    private FilmesDaoImpl filmesDao;
    @Autowired
    private RankingDaoImpl rankingDao;

    @GetMapping
    public List exibirFilmes(){
        return filmesDao.getBattleMovie();
    }

    //Gera o POST, o jogador pega o ID e responde no formato abaixo:
    //Post>Body>raw>JSON >
    //{"nome": "nomeDoUsuario", "senha": "senhaDoUsuario", "id": "idDoFiilme"}
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List getJogadaUsuario(@RequestBody String login, String senha, String id) {
        //TODO validar se usuario e senha existem
        var melhorFilme = validaID(id);
        if(melhorFilme != null){ //
            //TODO necessario implementar o calculo
        }
        return null;
    }

    //Realiza a validação do ID
    //Caso esteja correto, ele fara a validação do melhor filme (validaMelhorFilme)
    public Filmes validaID(String id){
        List<Filmes> listaFilme = filmesDao.filmesJogadaAtual();
        for (Filmes validaFilmeID : listaFilme)
            if (validaFilmeID.getId().equals(id)) {
                var melhorFilme = validaMelhorFilme(listaFilme);
                return melhorFilme;
            }
        return null;
    }

    public Filmes validaMelhorFilme(List filmes){
        //TODO valida se é o melhor filme escolhido, se sim, necessario realizar o calculo dos pontos de forma acumulativa
        //TODO se o usuario escolheu o filme com menor nota, diminui a vida e mantem os pontos anteriores
        //TODO Caso seja o 3 erro, pega os pontos atuais e insere em jogos.csv em seguida insere no ranking.csv
        return null;
    }

    @GetMapping("/ranking")
    public List ranking(){
        return rankingDao.linhaEmRanking();
    }

}
