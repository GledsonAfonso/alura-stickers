package com.gledsonafonso.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.gledsonafonso.model.ImdbMovie;
import com.gledsonafonso.service.ImdbService;

@Path("/imdb")
public class ImdbResource {
    @RestClient
    ImdbService service;

    @GET
    @Path("/top-250-movies")
    public List<ImdbMovie> getTop250Movies() {
        return service.getTop250Movies().items;
    }

    @GET
    @Path("/most-popular-movies")
    public List<ImdbMovie> getMostPopularMovies() {
        return service.getMostPopularMovies().items;
    }

    @GET
    @Path("/top-250-tvs")
    public List<ImdbMovie> getTop250TVs() {
        return service.getTop250TVs().items;
    }

    @GET
    @Path("/most-popular-tvs")
    public List<ImdbMovie> getMostPopularTVs() {
        return service.getMostPopularTVs().items;
    }
}