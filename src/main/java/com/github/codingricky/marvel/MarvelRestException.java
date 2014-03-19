package com.github.codingricky.marvel;

import org.apache.http.HttpResponse;

public class MarvelRestException extends RuntimeException {

    private final HttpResponse response;

    public MarvelRestException(HttpResponse response) {
        this.response = response;
    }
}
