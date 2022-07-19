package com.gledsonafonso.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbTop250MoviesResponse {
  @JsonProperty("items") public List<ImdbMovie> items;
  @JsonProperty("errorMessage") public String errorMessage;
}
