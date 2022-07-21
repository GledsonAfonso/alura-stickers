package com.gledsonafonso.service;

import javax.ws.rs.GET;

public interface CustomImdbService {
  @GET
  public byte[] getMovieImage();
}
