package com.github.codingricky.marvel;

import java.io.IOException;

import com.github.codingricky.marvel.model.Comic;
import com.github.codingricky.marvel.model.Event;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import com.github.codingricky.marvel.model.Series;
import com.github.codingricky.marvel.model.Story;
import com.github.codingricky.marvel.parameter.CharacterOrderBy;
import com.github.codingricky.marvel.parameter.CharacterParameterBuilder;
import com.github.codingricky.marvel.parameter.ComicOrderBy;
import com.github.codingricky.marvel.parameter.ComicParameterBuilder;
import com.github.codingricky.marvel.parameter.EventParameters;
import com.github.codingricky.marvel.parameter.EventParametersBuilder;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CharactersRestTest extends AbstractRestTest {
    @Test
    public void testGetCharacters() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new CharacterParameterBuilder().withLimit(5).create());
        assertThat(characters.getData()).isNotNull();
    }

    @Test
    public void testGetCharactersWithComics() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new CharacterParameterBuilder().withName("Black Widow").addComic(AVENGERS_COMIC_ID).orderBy(CharacterOrderBy.NAME_ASC).create());
        assertThat(characters.getData()).isNotNull();
    }

    @Test
    public void testGetCharacter() throws IOException {
        Result<MarvelCharacter> character = restClient.getCharacter(BLACK_WIDOW_ID);
        assertThat(character.getData()).isNotNull();
    }

    @Test
    public void testGetCharactersComics() throws IOException {
        Result<Comic> comics = restClient.getCharactersComics(new ComicParameterBuilder(BLACK_WIDOW_ID).create());
        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetCharactersComicsWithParameters() throws IOException {
        Result<Comic> comics = restClient.getCharactersComics(new ComicParameterBuilder(BLACK_WIDOW_ID)
                .withLimit(3)
                .addOrderBy(ComicOrderBy.FOC_DATE_ASC)
                .addOrderBy(ComicOrderBy.ISSUE_NUMBER_DESC).create());
        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetCharactersEvents() throws IOException {
        Result<Event> events = restClient.getCharactersEvents(new EventParametersBuilder(BLACK_WIDOW_ID).create());
        assertThat(events.getData()).isNotNull();
    }

    @Test
    public void testGetCharactersStories() throws IOException {
        Result<Story> stories = restClient.getCharactersStories(BLACK_WIDOW_ID);
        assertThat(stories.getData()).isNotNull();
    }

    @Test
    public void testGetCharactersSeries() throws IOException {
        Result<Series> series = restClient.getCharactersSeries(BLACK_WIDOW_ID);
        assertThat(series.getData()).isNotNull();
    }
}
