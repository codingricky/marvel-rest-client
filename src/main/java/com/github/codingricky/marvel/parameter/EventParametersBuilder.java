package com.github.codingricky.marvel.parameter;

import java.util.Date;

public class EventParametersBuilder {

    private EventParameters eventParameters;

    public EventParametersBuilder(Integer id) {
        this.eventParameters = new EventParameters(id);
    }

    public EventParametersBuilder withName(String name) {
        eventParameters.setName(name);
        return this;
    }

    public EventParametersBuilder withModifiedSince(Date modifiedSince) {
        eventParameters.setModifiedSince(modifiedSince);
        return this;
    }

    public EventParametersBuilder withLimit(Integer limit) {
        eventParameters.setLimit(limit);
        return this;
    }

    public EventParametersBuilder withOffset(Integer offset) {
        eventParameters.setOffset(offset);
        return this;
    }

    public EventParametersBuilder withCreators(Integer creator) {
        eventParameters.addCreator(creator);
        return this;
    }

    public EventParametersBuilder addSeries(Integer series) {
        eventParameters.addSeries(series);
        return this;
    }

    public EventParametersBuilder addStories(Integer story) {
        eventParameters.addStory(story);
        return this;
    }

    public EventParametersBuilder addOrderBy(EventsOrderBy orderBy) {
        eventParameters.addOrderBy(orderBy);
        return this;
    }

    public EventParameters create() {
        return eventParameters;
    }
}
