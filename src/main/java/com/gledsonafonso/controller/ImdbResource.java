package com.gledsonafonso.controller;

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
}