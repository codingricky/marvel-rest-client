package com.github.codingricky.marvel.parameter;

import java.util.ArrayList;
import java.util.List;

import gumi.builders.UrlBuilder;

public class EventParameters extends AbstractParameters {
    private Integer id;
    private String name;
    private List<EventsOrderBy> orderBy = new ArrayList<EventsOrderBy>();

    public EventParameters(Integer id) {
        this.id = id;
    }

    @Override
    public UrlBuilder addParameters(UrlBuilder urlBuilder) {
        urlBuilder = super.addParameters(urlBuilder);
        urlBuilder = addParameterToUrl("name", name, urlBuilder);
        return addParameterToUrl("orderBy", orderBy, urlBuilder);
    }

    public Integer getId() {
        return id;
    }

    void setName(String name) {
        this.name = name;
    }


    void addOrderBy(EventsOrderBy orderBy) {
        this.orderBy.add(orderBy);
    }
}
