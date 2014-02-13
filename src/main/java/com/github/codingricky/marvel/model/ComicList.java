package com.github.codingricky.marvel.model;

import com.google.common.base.Objects;

import java.util.List;

public class ComicList extends AbstractList {
    private List<ComicSummary> items;

    public List<ComicSummary> getItems() {
        return items;
    }

    public void setItems(List<ComicSummary> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .addValue(items)
                .addValue(available)
                .addValue(returned)
                .addValue(collectionURI)
                .toString();
    }
}
