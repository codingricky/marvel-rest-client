package com.github.codingricky.marvel.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ComicPrice {
    private String type;
    private float price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
