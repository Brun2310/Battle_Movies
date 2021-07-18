package battlemovies.dao;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RankingDaoImpl {
    private String caminhoRanking = "src\\main\\java\\battlemovies\\files\\ranking.csv";
    private Path pathRanking;

    @PostConstruct
    public void init(){
        pathRanking = Paths.get(caminhoRanking);
    }

    //Regra de pontuação
    //    0/3 = 0 prontos
    //    1/3 = 3 prontos
    //    2/3 = 6 prontos
    //    3/3 = 10 prontos
}
