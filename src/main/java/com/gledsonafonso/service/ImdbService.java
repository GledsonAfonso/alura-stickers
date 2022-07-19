package com.gledsonafonso.service;

import javax.ws.rs.GET;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.gledsonafonso.model.ImdbTop250MoviesResponse;

@RegisterRestClient(configKey="imdb-service-extensions-api")
public interface ImdbService {
  @GET
  public ImdbTop250MoviesResponse getTop250Movies();
}
