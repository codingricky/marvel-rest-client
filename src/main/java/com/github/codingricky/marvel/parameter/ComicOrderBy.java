package com.github.codingricky.marvel.parameter;

public enum ComicOrderBy {

    FOC_DATE_ASC("focDate"),
    ON_SALE_DATE_ASC("onSaleDate"),
    TITLE_ASC("title"),
    ISSUE_NUMBER_ASC("issueNumber"),
    MODIFIED_ASC("modified"),
    FOC_DATE_DESC("-focDate"),
    ON_SALE_DATE_DESC("-onSaleDate"),
    TITLE_DESC("-title"),
    ISSUE_NUMBER_DESC("-issueNumber"),
    MODIFIED_DESC("-modified"),;

    private final String string;

    private ComicOrderBy(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
