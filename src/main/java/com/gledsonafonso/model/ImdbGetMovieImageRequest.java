package com.gledsonafonso.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbGetMovieImageRequest {
  @JsonProperty("title")
  public String title;

  @JsonProperty("phrase")
  public String phrase;
}
