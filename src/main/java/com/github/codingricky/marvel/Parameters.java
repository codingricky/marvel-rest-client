package com.github.codingricky.marvel;

import java.util.Date;

import gumi.builders.UrlBuilder;

public class Parameters {
    private String name;
    private Date modifiedSince;
    private Integer comics;
    private Integer series;
    private Integer limit;
    private Integer offset;
    private StringBuilder orderBy;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getModifiedSince() {
        return modifiedSince;
    }

    public void setModifiedSince(Date modifiedSince) {
        this.modifiedSince = modifiedSince;
    }

    public Integer getComics() {
        return comics;
    }

    public void setComics(Integer comics) {
        this.comics = comics;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void addOrderBy(String orderBy) {
        if (this.orderBy == null) {
            this.orderBy = new StringBuilder(orderBy);
        } else {
            this.orderBy.append(",");
            this.orderBy.append(orderBy);
        }
    }
}
