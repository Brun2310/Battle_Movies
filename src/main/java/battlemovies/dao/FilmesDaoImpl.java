package battlemovies.dao;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilmesDaoImpl {
    private String caminho = "src\\main\\java\\battlemovies\\files\\filmes.csv";
    private Path path;

    //Após a aplicação iniciar, carrega os arquivos "filmes.csv" (os filmes estarão pré definidos)
    @PostConstruct
    public void init(){
        path = Paths.get(caminho);
    }
}
