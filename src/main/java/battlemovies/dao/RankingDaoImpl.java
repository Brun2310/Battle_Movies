package battlemovies.dao;

import battlemovies.modelo.Ranking;
import battlemovies.modelo.Usuario;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class RankingDaoImpl {
    private String caminho = "src\\main\\java\\battlemovies\\files\\ranking.csv";
    private Path path;
    private List<Ranking> registroLinhas = new ArrayList<>();

    @PostConstruct
    public void init(){
        path = Paths.get(caminho);
    }
    //Regra de pontuação
    //    0/3 = 0 prontos
    //    1/3 = 3 prontos
    //    2/3 = 6 prontos
    //    3/3 = 10 prontos

    public List linhaEmRanking() {
        try (Stream<String> streamLinhas = Files.lines(Path.of(caminho))) {
            registroLinhas = streamLinhas
                    .filter(Predicate.not(String::isEmpty))
                    .map(Ranking::new)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return registroLinhas;
    }

    public String formatar(Ranking ranking) {
        return String.format("%s,%f\r\n",ranking.getNome(),ranking.getPontuacao());
    }

    public List<Ranking> getAll() {
        linhaEmRanking();
        return registroLinhas;
    }
}
