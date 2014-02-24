package com.github.codingricky.marvel.parameter;

public enum SeriesType {
    COLLECTION("collection"),
    ONE_SHOT("one shot"),
    LIMITED("limited"),
    ONGOING("ongoing");

    private final String string;

    private SeriesType(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
