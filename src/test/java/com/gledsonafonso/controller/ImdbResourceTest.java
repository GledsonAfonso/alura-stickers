package com.gledsonafonso.controller;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest
public class ImdbResourceTest {
  @Test
    public void testGetTop250MoviewEndpoint() {
        given()
            .when().get("/imdb/top-250-movies")
            .then()
            .statusCode(200)
            .body("$.size()", greaterThan(0));
    }
}
