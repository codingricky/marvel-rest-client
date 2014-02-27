package com.github.codingricky.marvel.parameter;

import java.util.Date;
import java.util.List;

public class SeriesParameters extends AbstractParameters {
    private Integer id;
    private String title;
    private SeriesType seriesType;
    private List<Format> contains;
    private List<ComicOrderBy> orderBy;

    public SeriesParameters(Integer id) {
        this.id = id;
    }
    void setTitle(String title) {
        this.title = title;
    }

    public void setSeriesType(SeriesType seriesType) {
        this.seriesType = seriesType;
    }

    public void setContains(List<Format> contains) {
        this.contains = contains;
    }

    public void setOrderBy(List<ComicOrderBy> orderBy) {
        this.orderBy = orderBy;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
