package com.github.codingricky.marvel.parameter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gumi.builders.UrlBuilder;

public class EventParameters extends AbstractParameters {
    private Integer id;
    private String name;
    private Date modifiedSince;
    private List<Integer> creators = new ArrayList<Integer>();
    private List<Integer> series = new ArrayList<Integer>();
    private List<Integer> comics = new ArrayList<Integer>();
    private List<Integer> stories = new ArrayList<Integer>();
    private List<EventsOrderBy> orderBy = new ArrayList<EventsOrderBy>();
    private Integer limit;
    private Integer offset;

    public EventParameters(Integer id) {
        this.id = id;
    }

    public UrlBuilder addParameters(UrlBuilder urlBuilder) {
        urlBuilder = addParameterToUrl("name" ,name, urlBuilder);
        urlBuilder = addModifiedSince(modifiedSince, urlBuilder);
        urlBuilder = addParameterToUrl("creators", creators, urlBuilder);
        urlBuilder = addParameterToUrl("series", series, urlBuilder);
        urlBuilder = addParameterToUrl("comics", comics, urlBuilder);
        urlBuilder = addParameterToUrl("stories", stories, urlBuilder);
        urlBuilder = addParameterToUrl("orderBy", orderBy, urlBuilder);
        urlBuilder = addParameterToUrl("limit", limit, urlBuilder);
        urlBuilder = addParameterToUrl("offset", offset, urlBuilder);

        return urlBuilder;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModifiedSince(Date modifiedSince) {
        this.modifiedSince = modifiedSince;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void addCreators(Integer creator) {
        this.creators.add(creator);
    }

    public void addSeries(Integer series) {
        this.series.add(series);
    }

    public void addStories(Integer story) {
        this.stories.add(story);
    }

    public void addOrderBy(EventsOrderBy orderBy) {
        this.orderBy.add(orderBy);
    }
}
