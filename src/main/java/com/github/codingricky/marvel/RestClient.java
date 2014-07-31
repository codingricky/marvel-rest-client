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
import com.github.codingricky.marvel.parameter.CharacterParameters;
import com.github.codingricky.marvel.parameter.ComicParameters;
import com.github.codingricky.marvel.parameter.CreatorParameters;
import com.github.codingricky.marvel.parameter.EventParameters;
import com.github.codingricky.marvel.parameter.SeriesParameters;
import com.github.codingricky.marvel.parameter.StoryParameters;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RestClient {

    private final URLFactory urlFactory;
    private final ObjectMapper objectMapper;
    private Proxy proxy;

    public RestClient(String privateKey, String publicKey) {
        this.urlFactory = new URLFactory(privateKey, publicKey);
        this.objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CollectionURIDeserializerModule",
                new Version(1, 0, 0, null, null, null));
        module.addDeserializer(CollectionURI.class, new CollectionURIDeserializer());
        objectMapper.registerModule(module);
    }


    public RestClient(String privateKey, String publicKey, Proxy proxy) {
        this(privateKey, publicKey);
        this.proxy = proxy;
    }
        /**
         * Fetches lists of characters.
         *
         * @param characterParameters
         * @return
         * @throws IOException
         */
    public Result<MarvelCharacter> getCharacters(CharacterParameters characterParameters) throws IOException {
        final String result = getURL(urlFactory.getCharactersURL(characterParameters));
        return convertToResult(MarvelCharacter.class, result);
    }

    /**
     * Fetches lists of characters filtered by character id.
     *
     * @param characterId
     * @return
     * @throws IOException
     */
    public Result<MarvelCharacter> getCharacter(int characterId) throws IOException {
        final String result = getURL(urlFactory.getCharacterURL(characterId));
        return convertToResult(MarvelCharacter.class, result);
    }

    /**
     * Fetches lists of comics filtered by character id.
     *
     * @param comicParameters
     * @return
     * @throws IOException
     */
    public Result<Comic> getCharactersComics(ComicParameters comicParameters) throws IOException {
        final String result = getURL(urlFactory.getCharactersComicsURL(comicParameters));
        return convertToResult(Comic.class, result);
    }

    /**
     * Fetches lists of events filtered by character id.
     *
     * @param eventParameters
     * @return
     * @throws IOException
     */
    public Result<Event> getCharactersEvents(EventParameters eventParameters) throws IOException {
        final String result = getURL(urlFactory.getCharactersEventURL(eventParameters));
        return convertToResult(Event.class, result);
    }

    /**
     * Fetches lists of stories filtered by character id.
     *
     * @param storyParameters
     * @return
     * @throws IOException
     */
    public Result<Story> getCharactersStories(StoryParameters storyParameters) throws IOException {
        final String result = getURL(urlFactory.getCharactersStoriesURL(storyParameters));
        return convertToResult(Story.class, result);
    }

    /**
     * Fetches lists of series filtered by character id.
     *
     * @param seriesParameters
     * @return
     * @throws IOException
     */
    public Result<Series> getCharactersSeries(SeriesParameters seriesParameters) throws IOException {
        final String result = getURL(urlFactory.getCharactersSeriesURL(seriesParameters));
        return convertToResult(Series.class, result);
    }

    /**
     * Fetches a list of comics.
     *
     * @return
     * @throws IOException
     */
    public Result<Comic> getComics() throws IOException {
        final String result = getURL(urlFactory.getComicsURL());
        return convertToResult(Comic.class, result);
    }

    /**
     * Fetches a single comic by id.
     *
     * @param comicId
     * @return
     * @throws IOException
     */
    public Result<Comic> getComics(int comicId) throws IOException {
        final String result = getURL(urlFactory.getComicsURL(comicId));
        return convertToResult(Comic.class, result);
    }

    /**
     * Fetches lists of characters filtered by comic id.
     *
     * @param comicParameters
     * @return
     * @throws IOException
     */
    public Result<MarvelCharacter> getComicsCharacters(ComicParameters comicParameters) throws IOException {
        final String result = getURL(urlFactory.getComicsCharactersURL(comicParameters));
        return convertToResult(MarvelCharacter.class, result);
    }

    /**
     * Fetches lists of events filtered by a comic id.
     *
     * @param eventParameters
     * @return
     * @throws IOException
     */
    public Result<Event> getComicsEvents(EventParameters eventParameters) throws IOException {
        final String result = getURL(urlFactory.getComicsEventsURL(eventParameters));
        return convertToResult(Event.class, result);
    }

    /**
     * Fetches lists of stories filtered by a comic id.
     *
     * @param storyParameters
     * @return
     * @throws IOException
     */
    public Result<Story> getComicsStories(StoryParameters storyParameters) throws IOException {
        final String result = getURL(urlFactory.getComicsStoriesURL(storyParameters));
        return convertToResult(Story.class, result);
    }

    /**
     * Fetches lists of creators filtered by comic id.
     *
     * @param creatorParameters
     * @return
     * @throws IOException
     */
    public Result<Creator> getComicsCreators(CreatorParameters creatorParameters) throws IOException {
        final String result = getURL(urlFactory.getComicsCreatorsURL(creatorParameters));
        return convertToResult(Creator.class, result);
    }

    /**
     * Fetches list of events.
     *
     * @return
     * @throws IOException
     */
    public Result<Event> getEvents() throws IOException {
        final String result = getURL(urlFactory.getEventsURL());
        return convertToResult(Event.class, result);
    }

    /**
     * Fetches a single event by id.
     *
     * @param eventId
     * @return
     * @throws IOException
     */
    public Result<Event> getEvents(int eventId) throws IOException {
        final String result = getURL(urlFactory.getEventsURL(eventId));
        return convertToResult(Event.class, result);
    }

    /**
     * Fetches lists of characters filtered by an event id.
     *
     * @param eventParameters
     * @return
     * @throws IOException
     */
    public Result<MarvelCharacter> getEventsCharacters(EventParameters eventParameters) throws IOException {
        final String result = getURL(urlFactory.getEventsCharactersURL(eventParameters));
        return convertToResult(MarvelCharacter.class, result);
    }

    /**
     * Fetches lists of comics filtered by an event id.
     *
     * @param eventParameters
     * @return
     * @throws IOException
     */
    public Result<Comic> getEventsComics(EventParameters eventParameters) throws IOException {
        final String result = getURL(urlFactory.getEventsComicsURL(eventParameters));
        return convertToResult(Comic.class, result);
    }

    /**
     * Fetches lists of creators filtered by an event id.
     *
     * @param eventParameters
     * @return
     * @throws IOException
     */
    public Result<Creator> getEventsCreators(EventParameters eventParameters) throws IOException {
        final String result = getURL(urlFactory.getEventsCreatorsURL(eventParameters));
        return convertToResult(Creator.class, result);
    }

    /**
     * Fetches lists of stories filtered by an event id.
     * @param eventParameters
     * @return
     * @throws IOException
     */
    public Result<Story> getEventsStories(EventParameters eventParameters) throws IOException {
        final String result = getURL(urlFactory.getEventsStoriesURL(eventParameters));
        return convertToResult(Story.class, result);
    }

    /**
     * Fetches lists of series.
     *
     * @return
     * @throws IOException
     */
    public Result<Series> getSeries() throws IOException {
        final String result = getURL(urlFactory.getSeriesURL());
        return convertToResult(Series.class, result);
    }

    /**
     * Fetches a single comic series by id.
     *
     * @param seriesId
     * @return
     * @throws IOException
     */
    public Result<Series> getSeries(int seriesId) throws IOException {
        final String result = getURL(urlFactory.getSeriesURL(seriesId));
        return convertToResult(Series.class, result);
    }

    /**
     * Fetches lists of characters by a series id.
     *
     * @param seriesParameters
     * @return
     * @throws IOException
     */
    public Result<MarvelCharacter> getSeriesCharacters(SeriesParameters seriesParameters) throws IOException {
        final String result = getURL(urlFactory.getSeriesCharactersURL(seriesParameters));
        return convertToResult(MarvelCharacter.class, result);
    }

    /**
     * Fetches lists of comics by a series id.
     *
     * @param seriesParameters
     * @return
     * @throws IOException
     */
    public Result<Comic> getSeriesComics(SeriesParameters seriesParameters) throws IOException {
        final String result = getURL(urlFactory.getSeriesComicsURL(seriesParameters));
        return convertToResult(Comic.class, result);
    }

    /**
     * Fetches lists of creators by a series id.
     *
     * @param seriesParameters
     * @return
     * @throws IOException
     */
    public Result<Creator> getSeriesCreators(SeriesParameters seriesParameters) throws IOException {
        final String result = getURL(urlFactory.getSeriesCreatorsURL(seriesParameters));
        return convertToResult(Creator.class, result);
    }

    /**
     * Fetches lists of stories by a series id.
     *
     * @param seriesParameters
     * @return
     * @throws IOException
     */
    public Result<Story> getSeriesStories(SeriesParameters seriesParameters) throws IOException {
        final String result = getURL(urlFactory.getSeriesStoriesURL(seriesParameters));
        return convertToResult(Story.class, result);
    }


    /**
     * Fetches lists of stories.
     *
     * @return
     * @throws IOException
     */
    public Result<Story> getStories() throws IOException {
        final String result = getURL(urlFactory.getStoriesURL());
        return convertToResult(Story.class, result);
    }

    /**
     * Fetches lists of stories filtered by story id.
     *
     * @param storyId
     * @return
     * @throws IOException
     */
    public Result<Story> getStories(int storyId) throws IOException {
        final String result = getURL(urlFactory.getStoriesURL(storyId));
        return convertToResult(Story.class, result);
    }

    /**
     * Fetches lists of characters filtered by story id.
     *
     * @param storyParameters
     * @return
     * @throws IOException
     */
    public Result<MarvelCharacter> getStoriesCharacters(StoryParameters storyParameters) throws IOException {
        final String result = getURL(urlFactory.getStoriesCharactersURL(storyParameters));
        return convertToResult(MarvelCharacter.class, result);
    }

    /**
     * Fetches lists of comics filtered by story id.
     *
     * @param storyParameters
     * @return
     * @throws IOException
     */
    public Result<Comic> getStoriesComics(StoryParameters storyParameters) throws IOException {
        final String result = getURL(urlFactory.getStoriesComicsURL(storyParameters));
        return convertToResult(Comic.class, result);
    }

    /**
     * Fetches lists of creators filtered by story id.
     *
     * @param storyParameters
     * @return
     * @throws IOException
     */
    public Result<Creator> getStoriesCreators(StoryParameters storyParameters) throws IOException {
        final String result = getURL(urlFactory.getStoriesCreatorsURL(storyParameters));
        return convertToResult(Creator.class, result);
    }

    private <T> Result<T> convertToResult(Class clazz, String result) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(Result.class, clazz);
        final Result<T> mappedResult = objectMapper.readValue(result, javaType);
        mappedResult.setRawResponse(result);
        return mappedResult;
    }

    private String getURL(String url) throws IOException {
        final HttpResponse httpResponse = getResponse(url);
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new MarvelRestException(httpResponse);
        }
        return EntityUtils.toString(httpResponse.getEntity());
    }

    private HttpResponse getResponse(String url) throws IOException {
        if (proxy == null) {
            return Request.Get(url).execute().returnResponse();
        } else {
            return Request.Get(url).viaProxy(new HttpHost(proxy.getHost(), proxy.getPort())).execute().returnResponse();
        }
    }
}
