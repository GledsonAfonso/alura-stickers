package com.gledsonafonso.service.restclient;

import javax.ws.rs.GET;

public interface CustomImdbRestClientService {
  @GET
  public byte[] getMovieImage();
}
