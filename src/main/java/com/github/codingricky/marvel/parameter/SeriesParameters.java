package com.github.codingricky.marvel.parameter;

import java.util.Date;
import java.util.List;

public class SeriesParameters {
    private Integer id;
    private String title;
    private Date modifiedSince;
    private List<Integer> comics;
    private List<Integer> stories;
    private List<Integer> events;
    private List<Integer> creators;
    private SeriesType seriesType;
    private List<Format> contains;
    private List<ComicsOrderBy> orderBy;
    private Integer limit;
    private Integer offset;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setModifiedSince(Date modifiedSince) {
        this.modifiedSince = modifiedSince;
    }

    public void setComics(List<Integer> comics) {
        this.comics = comics;
    }

    public void setStories(List<Integer> stories) {
        this.stories = stories;
    }

    public void setEvents(List<Integer> events) {
        this.events = events;
    }

    public void setCreators(List<Integer> creators) {
        this.creators = creators;
    }

    public void setSeriesType(SeriesType seriesType) {
        this.seriesType = seriesType;
    }

    public void setContains(List<Format> contains) {
        this.contains = contains;
    }

    public void setOrderBy(List<ComicsOrderBy> orderBy) {
        this.orderBy = orderBy;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
