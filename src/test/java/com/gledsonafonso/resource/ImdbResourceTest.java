package com.gledsonafonso.resource;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.gledsonafonso.model.ImdbGetMovieImageRequest;

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

  @Test
  public void testGetImageWithPhraseEndpoint() {
    var requestBody = new ImdbGetMovieImageRequest();
    requestBody.movieName = "The Shawshank Redemption";
    requestBody.imageSubtitle = "some smart comment here";

    var response = given()
        .header("Content-type", "application/json")
        .and()
        .body(requestBody)
        .when()
        .post("/imdb/image-with-phrase")
        .then()
        .statusCode(200)
        .extract().response();
    
    assertTrue(response.getBody().asByteArray().length > 0);
  }

  @Test
  public void testGetImageWithPhraseEndpointWithUnknowTitle() {
    var requestBody = new ImdbGetMovieImageRequest();
    requestBody.movieName = "asdfasdf";
    requestBody.imageSubtitle = "some smart comment here";

    given()
        .header("Content-type", "application/json")
        .and()
        .body(requestBody)
        .when()
        .post("/imdb/image-with-phrase")
        .then()
        .statusCode(204);
  }
}
