package com.github.codingricky.marvel;

import gumi.builders.UrlBuilder;
import org.apache.commons.codec.digest.DigestUtils;

public class URLFactory {

    private static final String BASE_URL = "http://gateway.marvel.com/v1/public/";

    private final String publicKey;
    private final String privateKey;

    public URLFactory(String privateKey, String publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public String getCharacterURL(int characterId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "characters/" + characterId);
        return addAuthorisationParameters(urlBuilder).toString();
    }

    public String getCharactersComicsURL(int characterId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "characters/" + characterId + "/comics");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getCharactersURL(Parameters parameters) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "characters");
        long timeStamp = System.currentTimeMillis();
        urlBuilder = parameters.addParameters(urlBuilder).addParameter("ts", String.valueOf(timeStamp))
                .addParameter("apikey", publicKey)
                .addParameter("hash", createHash(timeStamp));
        return urlBuilder.toString();
    }

    public String getCharactersEventURL(int characterId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "characters/" + characterId + "/events");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getCharactersStoriesURL(int characterId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "characters/" + characterId + "/events");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getCharactersSeriesURL(int characterId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "characters/" + characterId + "/series");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getComicsURL() {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "comics");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getComicsCharactersURL(int comicId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "comics/" + comicId + "/characters");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getComicsCreatorsURL(int comicId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "comics/" + comicId + "/creators");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getComicsEventsURL(int comicId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "comics/" + comicId + "/events");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getComicsStoriesURL(int comicId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "comics/" + comicId + "/stories");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    private UrlBuilder addAuthorisationParameters(UrlBuilder urlBuilder) {
        long timeStamp = System.currentTimeMillis();
        return urlBuilder.addParameter("ts", String.valueOf(timeStamp))
                .addParameter("apikey", publicKey)
                .addParameter("hash", createHash(timeStamp));
    }

    private String createHash(long timeStamp) {
        String stringToHash = timeStamp + privateKey + publicKey;
        return DigestUtils.md5Hex(stringToHash);
    }

    public String getComicsURL(int comicId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "comics/" + comicId);
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getEventsURL() {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "events");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getEventsURL(int eventId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "events/" + eventId);
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getEventsCharactersURL(int eventId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "events/" + eventId + "/characters");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getEventsStoriesURL(int eventId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "events/" + eventId + "/stories");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getEventsCreatorsURL(int eventId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "events/" + eventId + "/creators");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getEventsComicsURL(int eventId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "events/" + eventId + "/comics");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getSeriesURL() {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "series");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getSeriesURL(int seriesId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "series/" + seriesId);
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getSeriesCharactersURL(int seriesId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "series/" + seriesId + "/characters");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getSeriesComicsURL(int seriesId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "series/" + seriesId + "/comics");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getSeriesCreatorsURL(int seriesId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "series/" + seriesId + "/creators");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getSeriesStoriesURL(int seriesId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "series/" + seriesId + "/stories");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getStoriesURL() {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "stories");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getStoriesURL(int storyId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "stories/" + storyId);
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getStoriesCharactersURL(int storyId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "stories/" + storyId + "/characters");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getStoriesComicsURL(int storyId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "stories/" + storyId + "/comics");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getStoriesCreatorsURL(int storyId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "stories/" + storyId + "/creators");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }
}
