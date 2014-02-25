package com.github.codingricky.marvel.parameter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.common.base.Joiner;
import gumi.builders.UrlBuilder;

public abstract class AbstractParameters {

    protected <T> UrlBuilder addParameterToUrl(String parameterName, T parameter, UrlBuilder urlBuilder) {
        if (parameter == null) return urlBuilder;
        String parameterAsString = parameter.toString();
        if (parameter instanceof List) {
            List parameterAsList = (List) parameter;
            if (parameterAsList.isEmpty()) return urlBuilder;
            // TODO need to support other types not just string
            parameterAsString = Joiner.on(',').join(parameterAsList);
        }
        return urlBuilder.addParameter(parameterName, parameterAsString);
    }

    protected UrlBuilder addModifiedSince(Date date, UrlBuilder urlBuilder) {
        if (date == null) return urlBuilder;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return urlBuilder.addParameter(simpleDateFormat.format(date), "modifiedSince");
    }
}
