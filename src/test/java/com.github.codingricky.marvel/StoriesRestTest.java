package com.github.codingricky.marvel;

import com.github.codingricky.marvel.model.Comic;
import com.github.codingricky.marvel.model.Creator;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import com.github.codingricky.marvel.model.Story;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StoriesRestTest extends AbstractRestTest {

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
