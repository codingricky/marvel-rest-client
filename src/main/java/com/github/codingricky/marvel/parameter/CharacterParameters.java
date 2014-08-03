package com.github.codingricky.marvel.parameter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gumi.builders.UrlBuilder;

public class CharacterParameters extends AbstractParameters {
    private String name;
    private List<CharacterOrderBy> orderBy = new ArrayList<CharacterOrderBy>();
    private String startsWith;

    @Override
    public UrlBuilder addParameters(UrlBuilder urlBuilder) {
        urlBuilder = super.addParameters(urlBuilder);
        urlBuilder = addParameterToUrl("name", name, urlBuilder);
        urlBuilder = addParameterToUrl("orderBy", orderBy, urlBuilder);
        urlBuilder = addParameterToUrl("nameStartsWith", startsWith, urlBuilder);
        return urlBuilder;
    }

    void setName(String name) {
        this.name = name;
    }

    void addOrderBy(CharacterOrderBy orderBy) {
        this.orderBy.add(orderBy);
    }

    public void setNameStartsWith(String startsWith) {
        this.startsWith = startsWith;
    }
}
