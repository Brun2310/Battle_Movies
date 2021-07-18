package battlemovies.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Filmes {
    @JsonProperty("imdbID")
    private int id;
    @JsonProperty("Titulo")
    private String title;
    @JsonProperty("imdbID")
    private Integer year;
    private Integer votosIMDB;
    private Double rattingIMDB;
    private Double score;

    @JsonProperty("Score")
    public void setScore(){
        this.score = this.rattingIMDB*this.votosIMDB;
    }

    @JsonProperty("Year")
    public void setYear(String year) {
        this.year = Integer.parseInt(year.substring(0,4));
}

}

