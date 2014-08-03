package com.github.codingricky.marvel;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MarvelRestException extends RuntimeException {

    private final HttpResponse response;

    public MarvelRestException(HttpResponse response) throws IOException {
        super(EntityUtils.toString(response.getEntity()));
        this.response = response;
    }
}
