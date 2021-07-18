package battlemovies.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filmes {
    private int id;
    private String nome;
    private int votosIMDB;
    private int rattingIMDB;
}
