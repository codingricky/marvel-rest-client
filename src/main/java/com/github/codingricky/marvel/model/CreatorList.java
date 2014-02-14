package com.github.codingricky.marvel.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CreatorList extends AbstractList {
    private List<CreatorSummary> items;

    public List<CreatorSummary> getItems() {
        return items;
    }

    public void setItems(List<CreatorSummary> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
