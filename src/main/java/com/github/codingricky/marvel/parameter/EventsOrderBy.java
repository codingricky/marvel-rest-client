package com.github.codingricky.marvel.parameter;

public enum EventsOrderBy {
    NAME_ASC("name"),
    START_DATE_ASC("startDate"),
    MODIFIED_ASC("modified"),
    NAME_DESC("-name"),
    START_DATE_DESC("-startDate"),
    MODIFIED_DESC("-modified"),;

    private final String string;

    private EventsOrderBy(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
