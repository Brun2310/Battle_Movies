package battlemovies.dao;

import java.nio.file.Path;

public class RankingDaoImpl {
    private String caminho = "src\\main\\java\\battlemovies\\files\\ranking.csv";
    private Path path;

    //Regra de pontuação
    //    0/3 = 0 prontos
    //    1/3 = 3 prontos
    //    2/3 = 6 prontos
    //    3/3 = 10 prontos
}
