package battlemovies.dao;

import battlemovies.modelo.Filmes;
import battlemovies.modelo.Ranking;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FilmesDaoImpl {
    private String caminho = "src\\main\\java\\battlemovies\\files\\filmes.csv";
    private Path path;
    private List<Filmes> registroLinhas = new ArrayList<>();

    @PostConstruct
    public void init(){
        path = Paths.get(caminho);
    }

    public List getBattleMovie(){
        //TODO teste pendente devido a erro no linhaEmFilme
        //Pega a lista completa de filmes, gera 2 ramdom para a batalha
        var filmes = getAll();
        var battleMovie = new ArrayList();
        Random random = new Random();
        Filmes filme1 = filmes.get(random.nextInt(filmes.size()));
        Filmes filme2 = filmes.get(random.nextInt(filmes.size()));
        battleMovie.add(filme1);
        battleMovie.add(filme2);
        return battleMovie;
    }

    public List linhaEmFilme() {
        try (Stream<String> streamLinhas = Files.lines(Path.of(caminho))) {
            registroLinhas = streamLinhas
                    .filter(Predicate.not(String::isEmpty))
                    .map(Filmes::new)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return registroLinhas;
    }

    public List<Filmes> getAll() {
        linhaEmFilme();
        return registroLinhas;
    }
}
