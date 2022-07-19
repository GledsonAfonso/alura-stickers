package com.gledsonafonso.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.gledsonafonso.model.ImdbTop250MoviesResponse;

@RegisterRestClient(configKey="imdb-service-extensions-api")
public interface ImdbService {
  String apiKey = "k_fy5353d7";


  @GET
  @Path("/Top250Movies/" + apiKey)
  public ImdbTop250MoviesResponse getTop250Movies();

  @GET
  @Path("/MostPopularMovies/" + apiKey)
  public ImdbTop250MoviesResponse getMostPopularMovies();
}
