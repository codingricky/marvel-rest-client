package com.github.codingricky.marvel;

import com.github.codingricky.marvel.model.Comic;
import com.github.codingricky.marvel.model.Creator;
import com.github.codingricky.marvel.model.Event;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import com.github.codingricky.marvel.model.Story;
import com.github.codingricky.marvel.parameter.ComicParametersBuilder;
import com.github.codingricky.marvel.parameter.CreatorParametersBuilder;
import com.github.codingricky.marvel.parameter.EventParametersBuilder;
import com.github.codingricky.marvel.parameter.StoryParametersBuilder;
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
    }

    @Test
    public void testGetComicsEvents() throws Exception {
        Result<Event> events = restClient.getComicsEvents(new EventParametersBuilder(AMAZING_SPIDER_MAN_COMIC_ID).create());
        assertThat(events.getData()).isNotNull();
    }

    @Test
    public void testGetComicsCharacters() throws Exception {
        Result<MarvelCharacter> characters = restClient.getComicsCharacters(new ComicParametersBuilder(AMAZING_SPIDER_MAN_COMIC_ID).create());
        assertThat(characters.getData()).isNotNull();
    }

    @Test
    public void testGetComicsCreators() throws Exception {
        Result<Creator> creators = restClient.getComicsCreators(new CreatorParametersBuilder(AMAZING_SPIDER_MAN_COMIC_ID).create());
        assertThat(creators.getData()).isNotNull();
    }

    @Test
    public void testGetComicsStories() throws Exception {
        Result<Story> stories = restClient.getComicsStories(new StoryParametersBuilder(AMAZING_SPIDER_MAN_COMIC_ID).create());
        assertThat(stories.getData()).isNotNull();
    }
}
