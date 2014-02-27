package com.github.codingricky.marvel.parameter;

import gumi.builders.UrlBuilder;

import java.util.ArrayList;
import java.util.List;

public class SeriesParameters extends AbstractParameters {
    private Integer id;
    private String title;
    private SeriesType seriesType;
    private List<Format> contains = new ArrayList<Format>();
    private List<SeriesOrderBy> orderBy = new ArrayList<SeriesOrderBy>();

    public SeriesParameters(Integer id) {
        this.id = id;
    }

    @Override
    public UrlBuilder addParameters(UrlBuilder urlBuilder) {
        urlBuilder = super.addParameters(urlBuilder);
        urlBuilder = addParameterToUrl("title", title, urlBuilder);
        urlBuilder = addParameterToUrl("seriesType", seriesType, urlBuilder);
        urlBuilder = addParameterToUrl("contains", contains, urlBuilder);
        return addParameterToUrl("orderBy", orderBy, urlBuilder);
    }

    public Integer getId() {
        return id;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setSeriesType(SeriesType seriesType) {
        this.seriesType = seriesType;
    }

    void addFormat(Format format) {
        this.contains.add(format);
    }

    void addOrderBy(SeriesOrderBy orderBy) {
        this.orderBy.add(orderBy);
    }

}
