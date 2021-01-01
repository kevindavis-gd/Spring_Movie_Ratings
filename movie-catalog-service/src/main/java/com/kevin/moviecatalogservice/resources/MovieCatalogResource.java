package com.kevin.moviecatalogservice.resources;


import com.kevin.moviecatalogservice.models.CatalogItem;
import com.kevin.moviecatalogservice.models.Movie;
import com.kevin.moviecatalogservice.models.Rating;
import com.kevin.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        RestTemplate restTemplate = new RestTemplate();
        UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+ userId, UserRating.class);

        return ratings.getUserRating().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), "Description", rating.getRating());
                })
                .collect(Collectors.toList());
    }

}

