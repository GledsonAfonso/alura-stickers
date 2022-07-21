package com.gledsonafonso.util;

import java.net.URI;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

public class RestClientUtils {
  public static <T> T getNewClientBuilder(String uri, Class<T> clazz) {
    return RestClientBuilder.newBuilder()
        .baseUri(URI.create(uri))
        .build(clazz);
  }
}
