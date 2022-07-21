package com.gledsonafonso.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbTopItemsResponse {
  @JsonProperty("items")
  public List<ImdbMovie> items;

  @JsonProperty("errorMessage")
  public String errorMessage;
}
