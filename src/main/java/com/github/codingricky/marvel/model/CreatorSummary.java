package com.github.codingricky.marvel.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CreatorSummary {
    private String resourceUri;
    private String name;
    private String role;

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
