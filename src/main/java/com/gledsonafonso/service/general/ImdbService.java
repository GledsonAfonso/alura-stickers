package com.gledsonafonso.service.general;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.gledsonafonso.model.ImdbGetMovieImageRequest;
import com.gledsonafonso.model.ImdbMovie;
import com.gledsonafonso.model.ImdbTopItemsResponse;
import com.gledsonafonso.util.ImageUtils;
import com.gledsonafonso.util.RestClientUtils;

@ApplicationScoped
public class ImdbService {
  @ConfigProperty(name = "imdb.url")
  String url;

  @ConfigProperty(name = "imdb.apiKey")
  String apiKey;

  public interface CustomHttpRestClient {
    @GET
    public ImdbTopItemsResponse get();
  }

  public List<ImdbMovie> getTop250Movies() {
    return RestClientUtils.getNewClientBuilder(url + "/Top250Movies/" + apiKey, CustomHttpRestClient.class)
        .get().items;
  }

  public List<ImdbMovie> getMostPopularMovies() {
    return RestClientUtils.getNewClientBuilder(url + "/MostPopularMovies/" + apiKey, CustomHttpRestClient.class)
        .get().items;
  }

  public List<ImdbMovie> getTop250TVs() {
    return RestClientUtils.getNewClientBuilder(url + "/Top250TVs/" + apiKey, CustomHttpRestClient.class)
        .get().items;
  }

  public List<ImdbMovie> getMostPopularTVs() {
    return RestClientUtils.getNewClientBuilder(url + "/MostPopularTVs/" + apiKey, CustomHttpRestClient.class)
        .get().items;
  }

  public byte[] getImageWithPhrase(ImdbGetMovieImageRequest request) {
    var filteredMovies = this.getTop250Movies()
        .stream()
        .filter(it -> it.title.toLowerCase().contains(request.movieName.toLowerCase()))
        .toList();

    if (!filteredMovies.isEmpty()) {
      var movie = filteredMovies.get(0);
      return ImageUtils.getImageAsByteArray(movie.image, request.imageSubtitle);
    } else {
      return null;
    }
  }
}
