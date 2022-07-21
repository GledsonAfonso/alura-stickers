package com.gledsonafonso.service.general;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.gledsonafonso.model.ImdbGetMovieImageRequest;
import com.gledsonafonso.model.ImdbMovie;
import com.gledsonafonso.service.restclient.CustomImdbRestClientService;
import com.gledsonafonso.service.restclient.ImdbRestClientService;
import com.gledsonafonso.util.RestClientUtils;

@ApplicationScoped
public class ImdbService {
  @RestClient
  private ImdbRestClientService restClientService;

  public List<ImdbMovie> getTop250Movies() {
    return restClientService.getTop250Movies().items;
  }

  public List<ImdbMovie> getMostPopularMovies() {
    return restClientService.getMostPopularMovies().items;
  }

  public List<ImdbMovie> getTop250TVs() {
    return restClientService.getTop250TVs().items;
  }

  public List<ImdbMovie> getMostPopularTVs() {
    return restClientService.getMostPopularTVs().items;
  }

  public byte[] getImageWithPhrase(ImdbGetMovieImageRequest request) {
    var filteredMovies = restClientService.getTop250Movies().items
        .stream()
        .filter(it -> it.title.toLowerCase().contains(request.title.toLowerCase()))
        .toList();

    return this.getImage(filteredMovies);
  }

  private byte[] getImage(List<ImdbMovie> filteredMovies) {
    try {
      var imdbMovie = filteredMovies.get(0);
      var customImdbRestClientService = RestClientUtils.getNewClientBuilder(imdbMovie.image, CustomImdbRestClientService.class);
      return customImdbRestClientService.getMovieImage();
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }
}
