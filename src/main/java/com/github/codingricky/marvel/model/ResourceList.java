package com.github.codingricky.marvel.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ResourceList {
    private int available;
    private int returned;
    private String collectionURI;
    private List items;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
