package com.github.codingricky.marvel.parameter;

import java.util.Date;

public class CreatorParametersBuilder {
    private final CreatorParameters creatorParameters;

    public CreatorParametersBuilder(Integer id) {
        creatorParameters = new CreatorParameters(id);
    }

    public CreatorParametersBuilder withFirstName(String firstName) {
        creatorParameters.setFirstName(firstName);
        return this;
    }

    public CreatorParametersBuilder withMiddleName(String middleName) {
        creatorParameters.setMiddleName(middleName);
        return this;
    }

    public CreatorParametersBuilder withLastName(String lastName) {
        creatorParameters.setLastName(lastName);
        return this;
    }

    public CreatorParametersBuilder withSuffix(String suffix) {
        creatorParameters.setSuffix(suffix);
        return this;
    }

    public CreatorParametersBuilder withModifiedSince(Date modifiedSince) {
        creatorParameters.setModifiedSince(modifiedSince);
        return this;
    }

    public CreatorParametersBuilder addComics(Integer comics) {
        creatorParameters.addComics(comics);
        return this;
    }

    public CreatorParametersBuilder addSeries(Integer seriesId) {
        creatorParameters.addSeries(seriesId);
        return this;
    }

    public CreatorParametersBuilder addStories(Integer story) {
        creatorParameters.addStory(story);
        return this;
    }


    public CreatorParametersBuilder withLimit(Integer limit) {
        creatorParameters.setLimit(limit);
        return this;
    }

    public CreatorParametersBuilder withOffset(Integer offset) {
        creatorParameters.setOffset(offset);
        return this;
    }


    public CreatorParameters create() {
        return creatorParameters;
    }
}
