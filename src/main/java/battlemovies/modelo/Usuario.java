package battlemovies.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {
    private String nome;
    private String senha;
    private  Integer pontos;

    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }
}
