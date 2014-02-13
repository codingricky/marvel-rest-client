package com.github.codingricky.marvel.model;

import com.google.common.base.Objects;

public class StorySummary {
    private String resourceURI;
    private String name;
    private String type;

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .addValue(resourceURI)
                .addValue(name)
                .addValue(type)
                .toString();
    }
}
