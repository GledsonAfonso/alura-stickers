package com.gledsonafonso.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.gledsonafonso.model.ImdbGetMovieImageRequest;
import com.gledsonafonso.model.ImdbMovie;
import com.gledsonafonso.service.ImdbService;

@Path("/imdb")
public class ImdbResource {
  @Inject
  ImdbService imdbService;

  @GET
  @Path("/top-250-movies")
  public List<ImdbMovie> getTop250Movies() {
    return imdbService.getTop250Movies();
  }

  @GET
  @Path("/most-popular-movies")
  public List<ImdbMovie> getMostPopularMovies() {
    return imdbService.getMostPopularMovies();
  }

  @GET
  @Path("/top-250-tvs")
  public List<ImdbMovie> getTop250TVs() {
    return imdbService.getTop250TVs();
  }

  @GET
  @Path("/most-popular-tvs")
  public List<ImdbMovie> getMostPopularTVs() {
    return imdbService.getMostPopularTVs();
  }

  @POST
  @Path("/image-with-phrase")
  @Produces("image/jpeg")
  public byte[] getImageWithPhrase(ImdbGetMovieImageRequest request) {
    return imdbService.getImageWithPhrase(request);
  }
}
