package com.github.codingricky.marvel;

import java.io.IOException;
import java.util.List;

import com.github.codingricky.marvel.model.Comic;
import com.github.codingricky.marvel.model.Event;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import com.github.codingricky.marvel.model.Series;
import com.github.codingricky.marvel.model.Story;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class RestClientTest {

    private static final int AMAZING_SPIDER_MAN_COMIC_ID = 6908;
    private static final int AVENGERS_COMIC_ID = 17519;
    private static final int BLACK_WIDOW_ID = 1009189;

    private RestClient restClient;

    @Before
    public void before() {
        String publicKey = System.getenv("PUBLIC_KEY");
        if (StringUtils.isBlank(publicKey)) {
            publicKey = System.getProperty("PUBLIC_KEY");
        }
        String privateKey = System.getenv("PRIVATE_KEY");
        if (StringUtils.isBlank(privateKey)) {
            privateKey = System.getProperty("PRIVATE_KEY");
        }

        assertThat(publicKey).isNotEmpty();
        assertThat(privateKey).isNotEmpty();

        restClient = new RestClient(privateKey, publicKey);
    }

    @Test
    public void testGetCharacters() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new ParameterBuilder().withLimit(5).create());
        assertThat(characters.getData().getCount()).isEqualTo(5);
    }

    @Test
    public void testGetCharactersWithName() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new ParameterBuilder().withName("Black Widow").create());
        assertThat(characters.getData().getTotal()).isEqualTo(1);
        MarvelCharacter blackWidow = characters.getData().getResults().get(0);
        assertThat(blackWidow.getName()).isEqualTo("Black Widow");
        assertThat(blackWidow.getId()).isEqualTo(BLACK_WIDOW_ID);
    }

    @Test
    public void testGetCharactersWithComics() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new ParameterBuilder().withName("Black Widow").addComic(AVENGERS_COMIC_ID).orderBy("name").create());

        assertThat(characters.getData().getCount()).isEqualTo(1);
        final List<MarvelCharacter> results = characters.getData().getResults();

        assertThat(results.get(0).getId()).isEqualTo(BLACK_WIDOW_ID);
    }

    @Test
    public void testGetCharactersOrderBy() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new ParameterBuilder().addComic(AMAZING_SPIDER_MAN_COMIC_ID).orderBy("-name").orderBy("modified").create());
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

}
