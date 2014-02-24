package com.github.codingricky.marvel.parameter;

import java.util.Date;

import org.apache.commons.lang3.Range;

public class ComicsParameterBuilder {
    private final ComicsParameters comicsParameters = new ComicsParameters();

    public ComicsParameterBuilder(int id) {
        comicsParameters.setId(id);
    }

    public ComicsParameterBuilder withFormat(Format format) {
        comicsParameters.setFormat(format);
        return this;
    }

    public ComicsParameterBuilder withFormatType(FormatType formatType) {
        comicsParameters.setFormatType(formatType);
        return this;
    }

    public ComicsParameterBuilder withNoVariants(Boolean noVariants) {
        comicsParameters.setNoVariants(noVariants);
        return this;
    }

    public ComicsParameterBuilder withDateDescriptor(DateDescriptor dateDescriptor) {
        comicsParameters.setDateDescriptor(dateDescriptor);
        return this;
    }

    public ComicsParameterBuilder withDateRange(Range<Date> dateRange) {
        comicsParameters.setDateRange(dateRange);
        return this;
    }

    public ComicsParameterBuilder withHasDigitalIssue(Boolean hasDigitalIssue) {
        comicsParameters.setHasDigitalIssue(hasDigitalIssue);
        return this;
    }

    public ComicsParameterBuilder withModifiedSince(Date modifiedSince) {
        comicsParameters.setModifiedSince(modifiedSince);
        return this;
    }

    public ComicsParameterBuilder addCreator(Integer creatorId) {
        comicsParameters.addCreator(creatorId);
        return this;
    }
    public ComicsParameterBuilder addSeries(Integer seriesId) {
        comicsParameters.addSeries(seriesId);
        return this;
    }
    public ComicsParameterBuilder addEvents(Integer creatorId) {
        comicsParameters.addEvent(creatorId);
        return this;
    }
    public ComicsParameterBuilder addStories(Integer storyId) {
        comicsParameters.addStory(storyId);
        return this;
    }

    // TODO better name required!
    public ComicsParameterBuilder addSharedAppearances(Integer characterId) {
        comicsParameters.addSharedAppearances(characterId);
        return this;
    }

    public ComicsParameterBuilder addCollaborators(Integer creatorId) {
        comicsParameters.addCollaborators(creatorId);
        return this;
    }

    public ComicsParameterBuilder addOrderBy(OrderBy orderBy) {
        comicsParameters.addOrderBy(orderBy);
        return this;
    }

    public ComicsParameterBuilder withLimit(Integer limit) {
        comicsParameters.setLimit(limit);
        return this;
    }

    public ComicsParameterBuilder withOffset(Integer offset) {
        comicsParameters.setOffset(offset);
        return this;
    }

    public ComicsParameters create() {
        return comicsParameters;
    }
}
