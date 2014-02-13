package com.github.codingricky.marvel.model;

import com.google.common.base.Objects;

public class URL {
    private String type;
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .addValue(type)
                .addValue(url)
                .toString();
    }
}
