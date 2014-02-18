package com.github.codingricky.marvel;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.codingricky.marvel.model.CollectionURI;
import com.github.codingricky.marvel.model.CollectionURIDeserializer;
import com.github.codingricky.marvel.model.Comic;
import com.github.codingricky.marvel.model.Creator;
import com.github.codingricky.marvel.model.Event;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import com.github.codingricky.marvel.model.Series;
import com.github.codingricky.marvel.model.Story;
import us.monoid.web.Resty;

import java.io.IOException;

public class RestClient {

    private final URLFactory urlFactory;
    private final ObjectMapper objectMapper;
    private final Resty resty;

    public RestClient(String privateKey, String publicKey) {
        this.urlFactory = new URLFactory(privateKey, publicKey);
        this.objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CollectionURIDeserializerModule",
                new Version(1, 0, 0, null, null, null));
        module.addDeserializer(CollectionURI.class, new CollectionURIDeserializer());
        objectMapper.registerModule(module);
        this.resty = new Resty();
    }

    public Result<Comic> getCharactersComics(int characterId) throws IOException {
        final String result = getURL(urlFactory.getCharactersComicsURL(characterId));
        return convertToResult(Comic.class, result);
    }

    public Result<Event> getCharactersEvents(int characterId) throws IOException {
        final String result = getURL(urlFactory.getCharactersEventURL(characterId));
        return convertToResult(Event.class, result);
    }

    public Result<Story> getCharactersStories(int characterId) throws IOException {
        final String result = getURL(urlFactory.getCharactersStoriesURL(characterId));
        return convertToResult(Story.class, result);
    }

    public Result<Series> getCharactersSeries(int characterId) throws IOException {
        final String result = getURL(urlFactory.getCharactersSeriesURL(characterId));
        return convertToResult(Series.class, result);
    }

    public Result<MarvelCharacter> getCharacters(Parameters parameters) throws IOException {
        final String result = getURL(urlFactory.getCharactersURL(parameters));
        return convertToResult(MarvelCharacter.class, result);
    }

    public Result<MarvelCharacter> getCharacter(int characterId) throws IOException {
        final String result = getURL(urlFactory.getCharacterURL(characterId));
        return convertToResult(MarvelCharacter.class, result);
    }

    public Result<Comic> getComics() throws IOException {
        final String result = getURL(urlFactory.getComicsURL());
        return convertToResult(Comic.class, result);
    }

    public Result<Comic> getComics(int comicId) throws IOException {
        final String result = getURL(urlFactory.getComicsURL(comicId));
        return convertToResult(Comic.class, result);
    }

    public Result<Event> getComicsEvents(int comicId) throws IOException {
        final String result = getURL(urlFactory.getComicsEventsURL(comicId));
        return convertToResult(Event.class, result);
    }

    public Result<Story> getComicsStories(int comicId) throws IOException {
        final String result = getURL(urlFactory.getComicsStoriesURL(comicId));
        return convertToResult(Story.class, result);
    }

    public Result<Creator> getComicsCreators(int comicId) throws IOException {
        final String result = getURL(urlFactory.getComicsCreatorsURL(comicId));
        return convertToResult(Creator.class, result);
    }

    public Result<MarvelCharacter> getComicsCharacters(int comicId) throws IOException {
        final String result = getURL(urlFactory.getComicsCharactersURL(comicId));
        return convertToResult(MarvelCharacter.class, result);
    }

    public Result<Event> getEvents() throws IOException {
        final String result = getURL(urlFactory.getEventsURL());
        return convertToResult(Event.class, result);
    }

    public Result<Event> getEvents(int eventId) throws IOException {
        final String result = getURL(urlFactory.getEventsURL(eventId));
        return convertToResult(Event.class, result);
    }

    public Result<MarvelCharacter> getEventsCharacters(int eventId) throws IOException {
        final String result = getURL(urlFactory.getEventsCharactersURL(eventId));
        return convertToResult(MarvelCharacter.class, result);
    }

    public Result<Comic> getEventsComics(int eventId) throws IOException {
        final String result = getURL(urlFactory.getEventsComicsURL(eventId));
        return convertToResult(Comic.class, result);
    }

    public Result<Creator> getEventsCreators(int eventId) throws IOException {
        final String result = getURL(urlFactory.getEventsCreatorsURL(eventId));
        return convertToResult(Creator.class, result);
    }

    public Result<Story> getEventsStories(int eventId) throws IOException {
        final String result = getURL(urlFactory.getEventsStoriesURL(eventId));
        return convertToResult(Story.class, result);
    }

    public Result<Series> getSeries() throws IOException {
        final String result = getURL(urlFactory.getSeriesURL());
        return convertToResult(Series.class, result);
    }

    public Result<Series> getSeries(int seriesId) throws IOException {
        final String result = getURL(urlFactory.getSeriesURL(seriesId));
        return convertToResult(Series.class, result);
    }

    public Result<MarvelCharacter> getSeriesCharacters(int seriesId) throws IOException {
        final String result = getURL(urlFactory.getSeriesCharactersURL(seriesId));
        return convertToResult(MarvelCharacter.class, result);
    }

    public Result<Comic> getSeriesComics(int seriesId) throws IOException {
        final String result = getURL(urlFactory.getSeriesComicsURL(seriesId));
        return convertToResult(Comic.class, result);
    }

    public Result<Creator> getSeriesCreators(int seriesId) throws IOException {
        final String result = getURL(urlFactory.getSeriesCreatorsURL(seriesId));
        return convertToResult(Creator.class, result);
    }

    public Result<Story> getSeriesStories(int seriesId) throws IOException {
        final String result = getURL(urlFactory.getSeriesStoriesURL(seriesId));
        return convertToResult(Story.class, result);
    }

    public Result<Story> getStories() throws IOException {
        final String result = getURL(urlFactory.getStoriesURL());
        return convertToResult(Story.class, result);
    }

    public Result<Story> getStories(int storyId) throws IOException {
        final String result = getURL(urlFactory.getStoriesURL(storyId));
        return convertToResult(Story.class, result);
    }

    public Result<MarvelCharacter> getStoriesCharacters(int storyid) throws IOException {
        final String result = getURL(urlFactory.getStoriesCharactersURL(storyid));
        return convertToResult(MarvelCharacter.class, result);
    }

    public Result<Comic> getStoriesComics(int storyId) throws IOException {
        final String result = getURL(urlFactory.getStoriesComicsURL(storyId));
        return convertToResult(Comic.class, result);
    }

    public Result<Creator> getStoriesCreators(int storyId) throws IOException {
        final String result = getURL(urlFactory.getStoriesCreatorsURL(storyId));
        return convertToResult(Creator.class, result);
    }

    private <T> Result<T> convertToResult(Class clazz, String result) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(Result.class, clazz);
        return objectMapper.readValue(result, javaType);
    }

    private String getURL(String url) throws IOException {
        return resty.text(url).toString();
    }
}
