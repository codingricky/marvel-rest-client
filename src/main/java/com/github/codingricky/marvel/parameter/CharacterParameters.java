package com.github.codingricky.marvel.parameter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gumi.builders.UrlBuilder;

public class CharacterParameters extends AbstractParameters {
    private String name;
    private Date modifiedSince;
    private List<Integer> comics = new ArrayList<Integer>();
    private List<Integer> series = new ArrayList<Integer>();
    private List<CharacterOrderBy> orderBy = new ArrayList<CharacterOrderBy>();
    private Integer limit;
    private Integer offset;

    public UrlBuilder addParameters(UrlBuilder urlBuilder) {
        urlBuilder = addParameterToUrl("name", name, urlBuilder);
        urlBuilder = addParameterToUrl("modifiedSince", modifiedSince, urlBuilder);
        urlBuilder = addParameterToUrl("comics", comics, urlBuilder);
        urlBuilder = addParameterToUrl("orderBy", orderBy, urlBuilder);
        urlBuilder = addParameterToUrl("limit", limit, urlBuilder);
        urlBuilder = addParameterToUrl("offset", offset, urlBuilder);
        return urlBuilder;
    }

    public void addOrderBy(CharacterOrderBy orderBy) {
        this.orderBy.add(orderBy);
    }

    public void addComics(Integer comics) {
        this.comics.add(comics);
    }

    public void addSeries(Integer series) {
        this.series.add(series);
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
}
