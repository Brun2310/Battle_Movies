package battlemovies.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ranking {
    private String nome;
    private Long pontuacao;

    public Ranking(String txtLinhas) {
        String[] split = txtLinhas.split(",");
        this.nome = split[0].trim().replace("\"", "");
        this.pontuacao= Long.parseLong(split[1].trim().replace("\"", ""));
    }
}
