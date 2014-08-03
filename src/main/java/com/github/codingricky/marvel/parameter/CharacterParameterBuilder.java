package com.github.codingricky.marvel.parameter;

import java.util.Date;

public class CharacterParameterBuilder {

    private final CharacterParameters characterParameters;

    public CharacterParameterBuilder() {
        this.characterParameters = new CharacterParameters();
    }

    public CharacterParameterBuilder withName(String name) {
        characterParameters.setName(name);
        return this;
    }

    public CharacterParameterBuilder withModifiedSince(Date modifiedSince) {
        characterParameters.setModifiedSince(modifiedSince);
        return this;
    }

    public CharacterParameterBuilder addComic(Integer comics) {
        characterParameters.addComics(comics);
        return this;
    }

    public CharacterParameterBuilder addSeries(Integer series) {
        characterParameters.addSeries(series);
        return this;
    }

    public CharacterParameterBuilder withLimit(Integer limit) {
        characterParameters.setLimit(limit);
        return this;
    }

    public CharacterParameterBuilder withOffset(Integer offset) {
        characterParameters.setOffset(offset);
        return this;
    }

    public CharacterParameterBuilder orderBy(CharacterOrderBy orderBy) {
        characterParameters.addOrderBy(orderBy);
        return this;
    }

    public CharacterParameterBuilder nameStartsWith(String startsWith) {
        characterParameters.setNameStartsWith(startsWith);
        return this;
    }

    public CharacterParameters create() {
        return characterParameters;
    }
}
