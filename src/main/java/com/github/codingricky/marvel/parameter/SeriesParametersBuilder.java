package com.github.codingricky.marvel.parameter;

public class SeriesParametersBuilder {

    private final SeriesParameters seriesParameters;

    public SeriesParametersBuilder(Integer id) {
        this.seriesParameters = new SeriesParameters(id);
    }

    public SeriesParametersBuilder withTitle(String title) {
        seriesParameters.setTitle(title);
        return this;
    }

    public SeriesParametersBuilder withSeriesType(SeriesType seriesType) {
        seriesParameters.setSeriesType(seriesType);
        return this;
    }

    public SeriesParametersBuilder addFormat(Format format) {
        seriesParameters.addFormat(format);
        return this;
    }

    public SeriesParametersBuilder addOrderBy(SeriesOrderBy orderBy) {
        seriesParameters.addOrderBy(orderBy);
        return this;
    }

    public SeriesParameters create() {
        return seriesParameters;
    }
}
