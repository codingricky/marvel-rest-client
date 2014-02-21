package com.github.codingricky.marvel;

import java.io.IOException;
import java.util.List;

import com.github.codingricky.marvel.model.Comic;
import com.github.codingricky.marvel.model.Event;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import com.github.codingricky.marvel.model.Series;
import com.github.codingricky.marvel.model.Story;
import com.github.codingricky.marvel.parameter.CharacterParameterBuilder;
import com.github.codingricky.marvel.parameter.ComicsParameterBuilder;
import com.github.codingricky.marvel.parameter.DateDescriptor;
import com.github.codingricky.marvel.parameter.Format;
import com.github.codingricky.marvel.parameter.FormatType;
import org.apache.commons.lang3.Range;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CharactersRestTest extends AbstractRestTest {

    @Test
    public void testGetCharacters() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new CharacterParameterBuilder().withLimit(5).create());
        assertThat(characters.getData().getCount()).isEqualTo(5);
    }

    @Test
    public void testGetCharactersWithComics() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new CharacterParameterBuilder().withName("Black Widow").addComic(AVENGERS_COMIC_ID).orderBy("name").create());

        assertThat(characters.getData().getCount()).isEqualTo(1);
        final List<MarvelCharacter> results = characters.getData().getResults();

        assertThat(results.get(0).getId()).isEqualTo(BLACK_WIDOW_ID);
    }

    @Test
    public void testGetCharactersOrderBy() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new CharacterParameterBuilder().addComic(AMAZING_SPIDER_MAN_COMIC_ID).orderBy("-name").orderBy("modified").create());
        final List<MarvelCharacter> results = characters.getData().getResults();

        assertThat(results.get(0).getName()).isEqualTo("Spider-Man");
        assertThat(results.get(1).getName()).isEqualTo("Black Widow");
    }

    @Test
    public void testGetCharacter() throws IOException {
        Result<MarvelCharacter> character = restClient.getCharacter(BLACK_WIDOW_ID);
        assertThat(character.getData().getResults().get(0).getName().trim()).isEqualTo("Black Widow");
    }

    @Test
    public void testGetCharactersComics() throws IOException {
        Result<Comic> comics = restClient.getCharactersComics(BLACK_WIDOW_ID);
        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetCharactersComicsWithParameters() throws IOException {
        Result<Comic> comics = restClient.getCharactersComics(new ComicsParameterBuilder(AVENGERS_COMIC_ID)
                .withLimit(3)
                .withDateDescriptor(DateDescriptor.LAST_WEEK)
                .withDateRange(Range.between(new DateTime().toDate(),
                        new DateTime().plusDays(1).toDate()))
                .withFormat(Format.COMIC)
                .withFormatType(FormatType.COMIC)
                .withNoVariants(Boolean.TRUE)
                .withOffset(34)
                .create());

        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetCharactersEvents() throws IOException {
        Result<Event> events = restClient.getCharactersEvents(BLACK_WIDOW_ID);
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
