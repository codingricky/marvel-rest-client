package com.github.codingricky.marvel.model;

import com.google.common.base.Objects;

import java.util.List;

public class EventList {
    private int available;
    private int returned;
    private String collectionURI;
    private List<EventSummary> items;

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<EventSummary> getItems() {
        return items;
    }

    public void setItems(List<EventSummary> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .addValue(available)
                .addValue(returned)
                .addValue(collectionURI)
                .addValue(items)
                .toString();
    }
}
