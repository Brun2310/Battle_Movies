package battlemovies.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ResultSearch {

    @JsonProperty("Search")
    private List<Filmes> resultList;

    private Integer total;
    private Boolean response;

    @JsonProperty("totalResults")
    public void setTotal(String total) {
        this.total = Integer.parseInt(total);
    }

    @JsonProperty("Response")
    public void setResponse(String response) {
        this.response = Boolean.valueOf(response);
    }
}
