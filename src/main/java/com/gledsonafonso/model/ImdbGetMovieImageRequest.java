package com.gledsonafonso.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbGetMovieImageRequest {
  @JsonProperty("movie_name")
  public String movieName;

  @JsonProperty("image_subtitle")
  public String imageSubtitle;
}
