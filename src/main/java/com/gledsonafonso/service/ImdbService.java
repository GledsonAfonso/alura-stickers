package com.gledsonafonso.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.gledsonafonso.model.ImdbTopItemsResponse;

@RegisterRestClient(configKey="imdb-service-extensions-api")
public interface ImdbService {
  String apiKey = "k_fy5353d7";

  @GET
  @Path("/Top250Movies/" + apiKey)
  public ImdbTopItemsResponse getTop250Movies();

  @GET
  @Path("/MostPopularMovies/" + apiKey)
  public ImdbTopItemsResponse getMostPopularMovies();

  @GET
  @Path("/Top250TVs/" + apiKey)
  public ImdbTopItemsResponse getTop250TVs();

  @GET
  @Path("/MostPopularTVs/" + apiKey)
  public ImdbTopItemsResponse getMostPopularTVs();
}
