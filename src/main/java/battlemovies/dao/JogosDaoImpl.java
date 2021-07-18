package battlemovies.dao;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JogosDaoImpl {
    private String caminhoQuiz = "src\\main\\java\\battlemovies\\files\\jogos.csv";
    private Path pathQuiz;

    @PostConstruct
    public void init(){
        pathQuiz = Paths.get(caminhoQuiz);
    }

    public void jogosRealizados(){
        //Armazena login e acertos/totalTentativas
    }
}
