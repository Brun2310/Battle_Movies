package battlemovies.modelo;

import lombok.Data;

@Data
public class Filmes {
    private int id;
    private String nome;
    private int notaIMDB; //multiplicar imdbVotes e imbrRatting
}
