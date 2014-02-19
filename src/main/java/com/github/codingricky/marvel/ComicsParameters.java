package com.github.codingricky.marvel;

import java.util.Date;

import gumi.builders.UrlBuilder;
import org.apache.commons.lang3.Range;

public class ComicsParameters {
    private Format format;
    private FormatType formatType;
    private Boolean noVariants;
    private DateDescriptor dateDescriptor;
    private Range<Date> dateRange;
    private Boolean hasDigitalIssue;
    private Date modifiedSince;
    private StringBuilder creators;
    private StringBuilder series;
    private StringBuilder events;
    private StringBuilder stories;
    private StringBuilder sharedAppearances;
    private StringBuilder collaborators;
    private StringBuilder orderBy;
    private int limit;
    private int offset;

    public UrlBuilder addParameters(UrlBuilder urlBuilder) {
        addParameter(format, "format", urlBuilder);
        addParameter(formatType, "formatType", urlBuilder);
        addParameter(noVariants, "noVariants", urlBuilder);
        addParameter(dateDescriptor, "dateDescriptor", urlBuilder);

        return urlBuilder;
    }

    private <T> void addParameter(T parameter, String parameterName, UrlBuilder urlBuilder) {
        if (urlBuilder == null) return;

        urlBuilder.addParameter(parameterName, parameter.toString());
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public void setFormatType(FormatType formatType) {
        this.formatType = formatType;
    }

    public void setNoVariants(Boolean noVariants) {
        this.noVariants = noVariants;
    }

    public void setDateDescriptor(DateDescriptor dateDescriptor) {
        this.dateDescriptor = dateDescriptor;
    }

    public void setDateRange(Range<Date> dateRange) {
        this.dateRange = dateRange;
    }

    public void setHasDigitalIssue(Boolean hasDigitalIssue) {
        this.hasDigitalIssue = hasDigitalIssue;
    }

    public void setModifiedSince(Date modifiedSince) {
        this.modifiedSince = modifiedSince;
    }

    public void setCreators(StringBuilder creators) {
        this.creators = creators;
    }

    public void setSeries(StringBuilder series) {
        this.series = series;
    }

    public void setEvents(StringBuilder events) {
        this.events = events;
    }

    public void setStories(StringBuilder stories) {
        this.stories = stories;
    }

    public void setSharedAppearances(StringBuilder sharedAppearances) {
        this.sharedAppearances = sharedAppearances;
    }

    public void setCollaborators(StringBuilder collaborators) {
        this.collaborators = collaborators;
    }

    public void setOrderBy(StringBuilder orderBy) {
        this.orderBy = orderBy;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
