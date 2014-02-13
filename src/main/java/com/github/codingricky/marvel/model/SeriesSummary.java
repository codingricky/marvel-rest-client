package com.github.codingricky.marvel.model;

import com.google.common.base.Objects;

public class SeriesSummary {
    private String resourceURI;
    private String name;

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

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .addValue(resourceURI)
                .addValue(name)
                .toString();
    }
}
