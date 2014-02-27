package com.github.codingricky.marvel.parameter;

import java.util.Date;

public class StoryParametersBuilder {

    private final StoryParameters storyParameters;

    public StoryParametersBuilder(Integer id) {
        this.storyParameters = new StoryParameters(id);
    }

    public StoryParametersBuilder withModifiedSince(Date modifiedSince) {
        storyParameters.setModifiedSince(modifiedSince);
        return this;
    }

    public StoryParametersBuilder withLimit(Integer limit) {
        storyParameters.setLimit(limit);
        return this;
    }

    public StoryParametersBuilder withOffset(Integer offset) {
        storyParameters.setOffset(offset);
        return this;
    }


    public StoryParametersBuilder addSeries(Integer series) {
        storyParameters.addSeries(series);
        return this;
    }

    public StoryParametersBuilder addComics(Integer comics) {
        storyParameters.addComics(comics);
        return this;
    }

    public StoryParametersBuilder addEvents(Integer events) {
        storyParameters.addEvents(events);
        return this;
    }

    public StoryParametersBuilder addOrderBy(StoryOrderBy orderBy) {
        storyParameters.addOrderBy(orderBy);
        return this;
    }

    public StoryParameters create() {
        return storyParameters;
    }
}
