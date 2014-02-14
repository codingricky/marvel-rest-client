package com.github.codingricky.marvel.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class ComicDate {
    private String type;
    private Date date;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
