package com.github.codingricky.marvel.parameter;

import java.util.ArrayList;
import java.util.List;

public class StoryParameters extends AbstractParameters {

    private Integer id;
    private List<StoryOrderBy> orderBy = new ArrayList<StoryOrderBy>();

    public StoryParameters(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
