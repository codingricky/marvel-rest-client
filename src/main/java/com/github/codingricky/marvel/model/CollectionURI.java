package com.github.codingricky.marvel.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

class CollectionURI {
    private String service;
    private int id;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
