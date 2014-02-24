package com.github.codingricky.marvel.parameter;

import java.util.List;

import com.google.common.base.Joiner;
import gumi.builders.UrlBuilder;

public abstract class AbstractParameters {

    protected <T> UrlBuilder addParameterToUrl(T parameter, String parameterName, UrlBuilder urlBuilder) {
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
}
