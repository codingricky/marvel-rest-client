package com.github.codingricky.marvel.parameter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.common.base.Joiner;
import gumi.builders.UrlBuilder;
import org.apache.commons.lang3.Range;

public class ComicsParameters {

    private Integer id;
    private Format format;
    private FormatType formatType;
    private Boolean noVariants;
    private DateDescriptor dateDescriptor;
    private Range<Date> dateRange;
    private Boolean hasDigitalIssue;
    private Date modifiedSince;
    private List<String> creators = new ArrayList<String>();
    private List<String> series = new ArrayList<String>();
    private List<String> events = new ArrayList<String>();
    private List<String> stories = new ArrayList<String>();
    private List<String> sharedAppearances = new ArrayList<String>();
    private List<String> collaborators = new ArrayList<String>();
    private List<String> orderBy = new ArrayList<String>();
    private Integer limit;
    private Integer offset;

    public ComicsParameters() {
    }

    public UrlBuilder addParameters(UrlBuilder urlBuilder) {
        urlBuilder = addParameterToUrl(format, "format", urlBuilder);
        urlBuilder = addParameterToUrl(formatType, "formatType", urlBuilder);
        urlBuilder = addParameterToUrl(noVariants, "noVariants", urlBuilder);
        urlBuilder = addParameterToUrl(dateDescriptor, "dateDescriptor", urlBuilder);

        if (dateRange != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String low = simpleDateFormat.format(dateRange.getMinimum());
            String high = simpleDateFormat.format(dateRange.getMaximum());
            urlBuilder = addParameterToUrl(String.format("%s,%s", low, high), "dateRange", urlBuilder);
        }

        urlBuilder = addParameterToUrl(hasDigitalIssue, "hasDigitalIssue", urlBuilder);
        urlBuilder = addParameterToUrl(modifiedSince, "modifiedSince", urlBuilder);
        urlBuilder = addParameterToUrl(creators, "creators", urlBuilder);
        urlBuilder = addParameterToUrl(series, "series", urlBuilder);
        urlBuilder = addParameterToUrl(events, "events", urlBuilder);
        urlBuilder = addParameterToUrl(stories, "creators", urlBuilder);
        urlBuilder = addParameterToUrl(sharedAppearances, "creators", urlBuilder);
        urlBuilder = addParameterToUrl(collaborators, "collaborators", urlBuilder);
        urlBuilder = addParameterToUrl(orderBy, "orderBy", urlBuilder);
        urlBuilder = addParameterToUrl(limit, "limit", urlBuilder);
        urlBuilder = addParameterToUrl(offset, "offset", urlBuilder);

        System.out.println(urlBuilder);
        return urlBuilder;
    }

    public Integer getId() {
        return id;
    }

    public void addCreator(int parameter) {
        creators.add(String.valueOf(parameter));
    }

    public void addSeries(int parameter) {
        series.add(String.valueOf(parameter));
    }

    public void addEvent(int parameter) {
        events.add(String.valueOf(parameter));
    }

    public void addStory(int parameter) {
        stories.add(String.valueOf(parameter));
    }

    public void addSharedAppearances(int parameter) {
        sharedAppearances.add(String.valueOf(parameter));
    }

    public void addCollaborators(int parameter) {
        collaborators.add(String.valueOf(parameter));
    }

    public void addOrderBy(String orderBy) {
        this.orderBy.add(orderBy);
    }

    private <T> UrlBuilder addParameterToUrl(T parameter, String parameterName, UrlBuilder urlBuilder) {
        if (parameter == null) return urlBuilder;
        if (parameter instanceof List) {
            List parameterAsList = (List) parameter;
            if (parameterAsList.isEmpty()) return urlBuilder;
            parameterName = Joiner.on(',').join(parameterAsList);
        }
        return urlBuilder.addParameter(parameterName, parameter.toString());
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

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setId(int id) {
        this.id = id;
    }
}
