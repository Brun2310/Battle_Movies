package battlemovies.dao;

import battlemovies.modelo.Filmes;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@Component
public class FilmesDaoImpl {
    private String caminho = "src\\main\\java\\battlemovies\\files\\filmes.csv";
    private Path path;

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

    public Filmes linhaEmFilme(String linha){
        //TODO recebe a linha corretamente, mas os Votos e Rating estão ficando como null na atribuição
        StringTokenizer st = new StringTokenizer(linha,";");
        Filmes filme = new Filmes();
        filme.setId(st.nextToken());
        filme.setNome(st.nextToken());
        filme.setVotos(Long.valueOf(st.nextToken()));
        filme.setRating(Double.valueOf(st.nextToken()));
        return filme;
    }

    public List<Filmes> getAll() {
        List<Filmes> filmes =  new ArrayList<>();
        try(BufferedReader br = Files.newBufferedReader(path)){
            filmes = br.lines().map(this::linhaEmFilme).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filmes;
    }
}
