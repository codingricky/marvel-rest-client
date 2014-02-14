package com.github.codingricky.marvel;

import java.util.Date;

public class ParameterBuilder {

    private Parameters parameters = new Parameters();

    public ParameterBuilder withName(String name) {
        parameters.setName(name);
        return this;
    }

    public ParameterBuilder withModifiedSince(Date modifiedSince) {
        parameters.setModifiedSince(modifiedSince);
        return this;
    }

    public ParameterBuilder addComic(Integer comics) {
        parameters.addComics(comics);
        return this;
    }

    public ParameterBuilder addSeries(Integer series) {
        parameters.addSeries(series);
        return this;
    }

    public ParameterBuilder withLimit(Integer limit) {
        parameters.setLimit(limit);
        return this;
    }

    public ParameterBuilder withOffset(Integer offset) {
        parameters.setOffset(offset);
        return this;
    }

    public ParameterBuilder orderBy(String orderBy) {
        parameters.addOrderBy(orderBy);
        return this;
    }

    public Parameters create() {
        return parameters;
    }
}
