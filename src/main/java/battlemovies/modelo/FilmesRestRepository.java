package battlemovies.modelo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface FilmesRestRepository {

    @GetMapping
    ResultSearch search(@RequestParam("filmeTitle") String filmeTitle);
}
