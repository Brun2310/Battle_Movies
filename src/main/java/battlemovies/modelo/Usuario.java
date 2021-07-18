package battlemovies.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

    private String username;
    private String senha;
    private Integer pontos;
    private UUID id;

    private int vidas = 3 ;
    private List<Filmes> listaDoJogador;
    private double combo = 1;

    public Usuario(String username, String senha){
        this.username = username;
        this.senha = senha;
    }

}
