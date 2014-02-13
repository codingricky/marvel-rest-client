package com.github.codingricky.marvel.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class StoryList {
    private int available;
    private int returned;
    private String collectionURI;
    private List<StorySummary> items;

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

    public List<StorySummary> getItems() {
        return items;
    }

    public void setItems(List<StorySummary> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
