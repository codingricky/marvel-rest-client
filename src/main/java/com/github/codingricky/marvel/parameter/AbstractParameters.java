package com.github.codingricky.marvel.parameter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.common.base.Joiner;
import gumi.builders.UrlBuilder;

public abstract class AbstractParameters {

    protected Integer limit;
    protected Integer offset;
    protected Date modifiedSince;

    protected List<Integer> creators = new ArrayList<Integer>();
    protected List<Integer> series = new ArrayList<Integer>();
    protected List<Integer> comics = new ArrayList<Integer>();
    protected List<Integer> stories = new ArrayList<Integer>();
    protected List<Integer> events = new ArrayList<Integer>();

    public UrlBuilder addParameters(UrlBuilder urlBuilder) {
        urlBuilder = addParameterToUrl("limit", limit, urlBuilder);
        urlBuilder = addParameterToUrl("offset", offset, urlBuilder);
        urlBuilder = addParameterToUrl("creators", creators, urlBuilder);
        urlBuilder = addParameterToUrl("series", series, urlBuilder);
        urlBuilder = addParameterToUrl("comics", comics, urlBuilder);
        urlBuilder = addParameterToUrl("stories", stories, urlBuilder);
        urlBuilder = addParameterToUrl("events", events, urlBuilder);

        return addModifiedSince(modifiedSince, urlBuilder);
    }


    protected <T> UrlBuilder addParameterToUrl(String parameterName, T parameter, UrlBuilder urlBuilder) {
        if (parameter == null) return urlBuilder;
        String parameterAsString = parameter.toString();
        if (parameter instanceof List) {
            List parameterAsList = (List) parameter;
            if (parameterAsList.isEmpty()) return urlBuilder;
            // TODO need to support other types not just string
            parameterAsString = Joiner.on(',').join(parameterAsList);
        }
        return urlBuilder.addParameter(parameterName, parameterAsString);
    }

    protected UrlBuilder addModifiedSince(Date date, UrlBuilder urlBuilder) {
        if (date == null) return urlBuilder;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return urlBuilder.addParameter(simpleDateFormat.format(date), "modifiedSince");
    }

    protected void setModifiedSince(Date modifiedSince) {
        this.modifiedSince = modifiedSince;
    }

    protected void addCreator(Integer creator) {
        this.creators.add(creator);
    }

    protected void addSeries(Integer series) {
        this.series.add(series);
    }

    protected void addStory(Integer story) {
        this.stories.add(story);
    }

    protected void addComics(Integer comics) {
        this.comics.add(comics);
    }

    protected void addEvents(Integer events) {
        this.events.add(events);
    }

    protected void setLimit(Integer limit) {
        this.limit = limit;
    }

    protected void setOffset(Integer offset) {
        this.offset = offset;
    }
}
