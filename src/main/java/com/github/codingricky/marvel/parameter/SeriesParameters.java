package com.github.codingricky.marvel.parameter;

import java.util.Date;
import java.util.List;

public class SeriesParameters {
    private Integer id;
    private String title;
    private Date modifiedSince;
    private List<Integer> comics;
    private List<Integer> stories;
    private List<Integer> events;
    private List<Integer> creators;
    // private SeriesType seriesType;
    private List<Format> contains;
//    private List<OrderBy> orderBy;
    private Integer limit;
    private Integer offset;


}
