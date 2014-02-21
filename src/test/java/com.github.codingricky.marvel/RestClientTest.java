package com.github.codingricky.marvel;

import java.io.IOException;
import java.util.List;

import com.github.codingricky.marvel.model.Comic;
import com.github.codingricky.marvel.model.Creator;
import com.github.codingricky.marvel.model.Event;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import com.github.codingricky.marvel.model.Series;
import com.github.codingricky.marvel.model.Story;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class RestClientTest extends AbstractRestTest {

    @Test
    public void testGetEvents() throws Exception {
        Result<Event> events = restClient.getEvents();
        assertThat(events.getData()).isNotNull();
    }

    @Test
    public void testGetEventsByEventId() throws Exception {
        Result<Event> events = restClient.getEvents(ACTS_OF_VENGEANCE_EVENT_ID);
        assertThat(events.getData()).isNotNull();
        assertThat(events.getData().getResults().get(0).getTitle()).contains("Acts of Vengeance!");
    }

    @Test
    public void testGetEventsCharacters() throws Exception {
        Result<MarvelCharacter> characters = restClient.getEventsCharacters(ACTS_OF_VENGEANCE_EVENT_ID);
        assertThat(characters.getData()).isNotNull();
    }

    @Test
    public void testGetEventsComics() throws Exception {
        Result<Comic> comics = restClient.getEventsComics(ACTS_OF_VENGEANCE_EVENT_ID);
        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetEventsCreators() throws Exception {
        Result<Creator> creators = restClient.getEventsCreators(ACTS_OF_VENGEANCE_EVENT_ID);
        assertThat(creators.getData()).isNotNull();
    }

    @Test
    public void testGetEventsStories() throws Exception {
        Result<Story> stories = restClient.getEventsStories(ACTS_OF_VENGEANCE_EVENT_ID);
        assertThat(stories.getData()).isNotNull();
    }

    @Test
    public void testGetSeries() throws Exception {
        Result<Series> series = restClient.getSeries();
        assertThat(series.getData()).isNotNull();
    }

    @Test
    public void testGetSeriesBySeriesId() throws Exception {
        Result<Series> series = restClient.getSeries(FIFTEEN_LOVE_SERIES_ID);
        assertThat(series.getData()).isNotNull();
    }

    @Test
    public void testGetSeriesCharacters() throws Exception {
        Result<MarvelCharacter> characters = restClient.getSeriesCharacters(FIFTEEN_LOVE_SERIES_ID);
        assertThat(characters.getData()).isNotNull();
    }

    @Test
    public void testGetSeriesComics() throws Exception {
        Result<Comic> comics = restClient.getSeriesComics(FIFTEEN_LOVE_SERIES_ID);
        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetSeriesCreators() throws Exception {
        Result<Creator> creators = restClient.getSeriesCreators(FIFTEEN_LOVE_SERIES_ID);
        assertThat(creators.getData()).isNotNull();
    }

    @Test
    public void testGetSeriesStories() throws Exception {
        Result<Story> stories = restClient.getSeriesStories(FIFTEEN_LOVE_SERIES_ID);
        assertThat(stories.getData()).isNotNull();
    }

    @Test
    public void testGetStories() throws Exception {
        Result<Story> stories = restClient.getStories();
        assertThat(stories.getData()).isNotNull();
    }

    @Test
    public void testGetStoriesByStoryId() throws Exception {
        Result<Story> stories = restClient.getStories(STORY_ID);
        assertThat(stories.getData()).isNotNull();
    }

    @Test
    public void testGetStoriesCharacters() throws Exception {
        Result<MarvelCharacter> characters = restClient.getStoriesCharacters(STORY_ID);
        assertThat(characters.getData()).isNotNull();
    }

    @Test
    public void testGetStoriesComics() throws Exception {
        Result<Comic> comics = restClient.getStoriesComics(STORY_ID);
        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetStoriesCreators() throws Exception {
        Result<Creator> creators = restClient.getStoriesCreators(STORY_ID);
        assertThat(creators.getData()).isNotNull();
    }

}
