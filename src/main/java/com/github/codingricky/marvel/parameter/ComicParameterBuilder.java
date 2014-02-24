package com.github.codingricky.marvel.parameter;

import java.util.Date;

import org.apache.commons.lang3.Range;

public class ComicParameterBuilder {
    private final ComicParameters comicParameters = new ComicParameters();

    public ComicParameterBuilder(int id) {
        comicParameters.setId(id);
    }

    public ComicParameterBuilder withFormat(Format format) {
        comicParameters.setFormat(format);
        return this;
    }

    public ComicParameterBuilder withFormatType(FormatType formatType) {
        comicParameters.setFormatType(formatType);
        return this;
    }

    public ComicParameterBuilder withNoVariants(Boolean noVariants) {
        comicParameters.setNoVariants(noVariants);
        return this;
    }

    public ComicParameterBuilder withDateDescriptor(DateDescriptor dateDescriptor) {
        comicParameters.setDateDescriptor(dateDescriptor);
        return this;
    }

    public ComicParameterBuilder withDateRange(Range<Date> dateRange) {
        comicParameters.setDateRange(dateRange);
        return this;
    }

    public ComicParameterBuilder withHasDigitalIssue(Boolean hasDigitalIssue) {
        comicParameters.setHasDigitalIssue(hasDigitalIssue);
        return this;
    }

    public ComicParameterBuilder withModifiedSince(Date modifiedSince) {
        comicParameters.setModifiedSince(modifiedSince);
        return this;
    }

    public ComicParameterBuilder addCreator(Integer creatorId) {
        comicParameters.addCreator(creatorId);
        return this;
    }
    public ComicParameterBuilder addSeries(Integer seriesId) {
        comicParameters.addSeries(seriesId);
        return this;
    }
    public ComicParameterBuilder addEvents(Integer creatorId) {
        comicParameters.addEvent(creatorId);
        return this;
    }
    public ComicParameterBuilder addStories(Integer storyId) {
        comicParameters.addStory(storyId);
        return this;
    }

    // TODO better name required!
    public ComicParameterBuilder addSharedAppearances(Integer characterId) {
        comicParameters.addSharedAppearances(characterId);
        return this;
    }

    public ComicParameterBuilder addCollaborators(Integer creatorId) {
        comicParameters.addCollaborators(creatorId);
        return this;
    }

    public ComicParameterBuilder addOrderBy(ComicOrderBy orderBy) {
        comicParameters.addOrderBy(orderBy);
        return this;
    }

    public ComicParameterBuilder withLimit(Integer limit) {
        comicParameters.setLimit(limit);
        return this;
    }

    public ComicParameterBuilder withOffset(Integer offset) {
        comicParameters.setOffset(offset);
        return this;
    }

    public ComicParameters create() {
        return comicParameters;
    }
}
