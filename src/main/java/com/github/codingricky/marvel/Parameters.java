package com.github.codingricky.marvel;

import java.util.Date;

import gumi.builders.UrlBuilder;

public class Parameters {
    private String name;
    private Date modifiedSince;
    private StringBuilder comics;
    private StringBuilder series;
    private StringBuilder orderBy;
    private Integer limit;
    private Integer offset;

    public UrlBuilder addParameters(UrlBuilder urlBuilder) {
        if (name != null) {
            urlBuilder = urlBuilder.addParameter("name", name);
        }
        if (modifiedSince != null) {
            // TODO check date format
            urlBuilder = urlBuilder.addParameter("modifiedSince", modifiedSince.toString());
        }
        if (comics != null) {
            urlBuilder = urlBuilder.addParameter("comics", comics.toString());
        }
        if (series != null) {
            urlBuilder = urlBuilder.addParameter("series", series.toString());
        }
        if (limit != null) {
            urlBuilder = urlBuilder.addParameter("limit", limit.toString());
        }
        if (offset != null) {
            urlBuilder = urlBuilder.addParameter("offset", offset.toString());
        }
        if (orderBy != null) {
            urlBuilder = urlBuilder.addParameter("orderBy", orderBy.toString());
        }

        return urlBuilder;
    }

    public void addOrderBy(String orderBy) {
        if (this.orderBy == null) {
            this.orderBy = new StringBuilder(orderBy);
        } else {
            this.orderBy.append(",");
            this.orderBy.append(orderBy);
        }
    }

    public void addComics(Integer comics) {
        if (this.comics == null) {
            this.comics = new StringBuilder(comics);
        } else {
            this.comics.append(",");
            this.comics.append(comics);
        }
    }

    public void addSeries(Integer series) {
        if (this.series == null) {
            this.series = new StringBuilder(series);
        } else {
            this.series.append(",");
            this.series.append(series);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModifiedSince(Date modifiedSince) {
        this.modifiedSince = modifiedSince;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
