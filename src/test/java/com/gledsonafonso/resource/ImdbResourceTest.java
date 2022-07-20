package com.gledsonafonso.resource;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest
public class ImdbResourceTest {
  @Test
  public void testGetTop250MoviesEndpoint() {
    given()
        .when().get("/imdb/top-250-movies")
        .then()
        .statusCode(200)
        .body("$.size()", greaterThan(0));
  }

  @Test
  public void testGetMostPopularMoviesEndpoint() {
    given()
        .when().get("/imdb/most-popular-movies")
        .then()
        .statusCode(200)
        .body("$.size()", greaterThan(0));
  }

  @Test
  public void testGetTop250TvsEndpoint() {
    given()
        .when().get("/imdb/top-250-tvs")
        .then()
        .statusCode(200)
        .body("$.size()", greaterThan(0));
  }

  @Test
  public void testGetMostPopularTvsEndpoint() {
    given()
        .when().get("/imdb/most-popular-tvs")
        .then()
        .statusCode(200)
        .body("$.size()", greaterThan(0));
  }
}
