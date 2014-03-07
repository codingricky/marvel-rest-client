package com.github.codingricky.marvel;

import com.github.codingricky.marvel.model.Comic;
import com.github.codingricky.marvel.model.Creator;
import com.github.codingricky.marvel.model.Event;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import com.github.codingricky.marvel.model.Story;
import com.github.codingricky.marvel.parameter.EventParametersBuilder;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class EventsRestTest extends AbstractRestTest {

    @Test
    public void testGetEvents() throws Exception {
        Result<Event> events = restClient.getEvents();
        assertThat(events.getData()).isNotNull();
    }

    @Test
    public void testGetEventsByEventId() throws Exception {
        Result<Event> events = restClient.getEvents(ACTS_OF_VENGEANCE_EVENT_ID);
        assertThat(events.getData()).isNotNull();
    }

    @Test
    public void testGetEventsCharacters() throws Exception {
        Result<MarvelCharacter> characters = restClient.getEventsCharacters(new EventParametersBuilder(ACTS_OF_VENGEANCE_EVENT_ID).create());
        assertThat(characters.getData()).isNotNull();
    }

    @Test
    public void testGetEventsComics() throws Exception {
        Result<Comic> comics = restClient.getEventsComics(new EventParametersBuilder(ACTS_OF_VENGEANCE_EVENT_ID).create());
        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetEventsCreators() throws Exception {
        Result<Creator> creators = restClient.getEventsCreators(new EventParametersBuilder(ACTS_OF_VENGEANCE_EVENT_ID).create());
        assertThat(creators.getData()).isNotNull();
    }

    @Test
    public void testGetEventsStories() throws Exception {
        Result<Story> stories = restClient.getEventsStories(new EventParametersBuilder(ACTS_OF_VENGEANCE_EVENT_ID).create());
        assertThat(stories.getData()).isNotNull();
    }

}
