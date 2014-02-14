package com.github.codingricky.marvel.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class CharacterList extends AbstractList {
    private List<CharacterSummary> items;

    public List<CharacterSummary> getItems() {
        return items;
    }

    public void setItems(List<CharacterSummary> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
