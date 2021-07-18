package battlemovies.dao;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilmesDaoImpl {
    private String caminhoFilmes = "src\\main\\java\\battlemovies\\files\\filmes.csv";
    private Path pathFilmes;

    //Após a aplicação iniciar, carrega os arquivos "filmes.csv" (os filmes estarão pré definidos)
    @PostConstruct
    public void init(){
        pathFilmes = Paths.get(caminhoFilmes);
    }
}
