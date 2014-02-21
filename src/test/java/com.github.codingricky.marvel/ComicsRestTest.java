package com.github.codingricky.marvel;

import com.github.codingricky.marvel.model.Comic;
import com.github.codingricky.marvel.model.Creator;
import com.github.codingricky.marvel.model.Event;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import com.github.codingricky.marvel.model.Story;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ComicsRestTest extends AbstractRestTest {

    @Test
    public void testGetComics() throws Exception {
        Result<Comic> comics = restClient.getComics();
        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetComicsById() throws Exception {
        Result<Comic> comics = restClient.getComics(AMAZING_SPIDER_MAN_COMIC_ID);
        assertThat(comics.getData()).isNotNull();
        assertThat(comics.getData().getResults().get(0).getTitle()).contains("Amazing Spider-Man");
    }

    @Test
    public void testGetComicsEvents() throws Exception {
        Result<Event> events = restClient.getComicsEvents(AMAZING_SPIDER_MAN_COMIC_ID);
        assertThat(events.getData()).isNotNull();
    }

    @Test
    public void testGetComicsCharacters() throws Exception {
        Result<MarvelCharacter> characters = restClient.getComicsCharacters(AMAZING_SPIDER_MAN_COMIC_ID);
        assertThat(characters.getData()).isNotNull();
    }

    @Test
    public void testGetComicsCreators() throws Exception {
        Result<Creator> creators = restClient.getComicsCreators(AMAZING_SPIDER_MAN_COMIC_ID);
        assertThat(creators.getData()).isNotNull();
    }

    @Test
    public void testGetComicsStories() throws Exception {
        Result<Story> stories = restClient.getComicsStories(AMAZING_SPIDER_MAN_COMIC_ID);
        assertThat(stories.getData()).isNotNull();
    }
}
