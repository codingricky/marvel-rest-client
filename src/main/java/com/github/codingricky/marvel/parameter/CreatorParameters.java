package com.github.codingricky.marvel.parameter;

import gumi.builders.UrlBuilder;

import java.util.ArrayList;
import java.util.List;

public class CreatorParameters extends AbstractParameters {
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private List<CreatorOrderBy> orderBy = new ArrayList<CreatorOrderBy>();

    public CreatorParameters(Integer id) {
        this.id = id;
    }

    @Override
    public UrlBuilder addParameters(UrlBuilder urlBuilder) {
        urlBuilder = super.addParameters(urlBuilder);
        urlBuilder = addParameterToUrl("firstName", firstName, urlBuilder);
        urlBuilder = addParameterToUrl("middleName", middleName, urlBuilder);
        urlBuilder = addParameterToUrl("lastName", lastName, urlBuilder);
        urlBuilder = addParameterToUrl("suffix", suffix, urlBuilder);
        urlBuilder = addParameterToUrl("orderBy", orderBy, urlBuilder);
        return urlBuilder;
    }

    public Integer getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void addOrderBy(CreatorOrderBy orderBy) {
        this.orderBy.add(orderBy);
    }
}
