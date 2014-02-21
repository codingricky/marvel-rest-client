package com.github.codingricky.marvel.parameter;

public enum FormatType {

    COMIC("comic"), COLLECTION("collection");

    private final String string;

    private FormatType(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
