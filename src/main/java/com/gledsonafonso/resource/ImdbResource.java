package com.gledsonafonso.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.gledsonafonso.model.ImdbGetMovieImageRequest;
import com.gledsonafonso.model.ImdbMovie;
import com.gledsonafonso.service.CustomImdbService;
import com.gledsonafonso.service.ImdbService;
import com.gledsonafonso.util.RestClientUtils;

@Path("/imdb")
public class ImdbResource {
  @RestClient
  ImdbService imdbService;

  @GET
  @Path("/top-250-movies")
  public List<ImdbMovie> getTop250Movies() {
    return imdbService.getTop250Movies().items;
  }

  @GET
  @Path("/most-popular-movies")
  public List<ImdbMovie> getMostPopularMovies() {
    return imdbService.getMostPopularMovies().items;
  }

  @GET
  @Path("/top-250-tvs")
  public List<ImdbMovie> getTop250TVs() {
    return imdbService.getTop250TVs().items;
  }

  @GET
  @Path("/most-popular-tvs")
  public List<ImdbMovie> getMostPopularTVs() {
    return imdbService.getMostPopularTVs().items;
  }

  @POST
  @Path("/image-with-phrase")
  @Produces("image/jpeg")
  public byte[] getImageWithPhrase(ImdbGetMovieImageRequest request) {
    var filteredMovies = imdbService.getTop250Movies().items
        .stream()
        .filter(it -> it.title.toLowerCase().contains(request.title.toLowerCase()))
        .toList();

    return this.getImage(filteredMovies);
  }

  private byte[] getImage(List<ImdbMovie> filteredMovies) {
    try {
      var imdbMovie = filteredMovies.get(0);
      var customImdbService = RestClientUtils.getNewClientBuilder(imdbMovie.image, CustomImdbService.class);
      return customImdbService.getMovieImage();
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }
}